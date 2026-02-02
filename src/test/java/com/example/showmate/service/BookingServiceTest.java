package com.example.showmate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.showmate.model.Booking;
import com.example.showmate.model.Movie;
import com.example.showmate.model.Seat;
import com.example.showmate.model.Showtime;
import com.example.showmate.repository.BookingRepository;
import com.example.showmate.repository.MovieRepository;
import com.example.showmate.repository.SeatRepository;
import com.example.showmate.repository.ShowtimeRepository;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock private BookingRepository bookingRepository;
    @Mock private MovieRepository movieRepository;
    @Mock private ShowtimeRepository showtimeRepository;
    @Mock private SeatRepository seatRepository;
    @Mock private EmailService emailService;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void createBooking_whenNoSeats_throws() {
        Movie movie = new Movie("M", "D", "P");
        movie.setId(1L);
        Showtime showtime = new Showtime();
        showtime.setId(1L);

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
        when(showtimeRepository.findById(1L)).thenReturn(Optional.of(showtime));

        assertThatThrownBy(() -> bookingService.createBooking("a@b.com", 1L, 1L, List.of()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("select at least one seat");
    }

    @Test
    void createBooking_success_booksSeatsAndSavesBooking() {
        Movie movie = new Movie("M", "D", "P");
        movie.setId(1L);
        Showtime showtime = new Showtime();
        showtime.setId(2L);

        Seat seat = new Seat();
        seat.setSeatNumber("A1");
        seat.setBooked(false);
        seat.setShowtime(showtime);

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
        when(showtimeRepository.findById(2L)).thenReturn(Optional.of(showtime));
        when(seatRepository.findBySeatNumberAndShowtimeForUpdate("A1", showtime)).thenReturn(Optional.of(seat));

        when(seatRepository.save(any(Seat.class))).thenAnswer(inv -> inv.getArgument(0));
        when(bookingRepository.save(any(Booking.class))).thenAnswer(inv -> {
            Booking b = inv.getArgument(0);
            b.setId(99L);
            return b;
        });

        Booking saved = bookingService.createBooking("a@b.com", 1L, 2L, List.of("A1"));

        assertThat(saved.getId()).isEqualTo(99L);
        assertThat(seat.isBooked()).isTrue();
        verify(seatRepository).save(any(Seat.class));
        verify(bookingRepository).save(any(Booking.class));
        verify(emailService).sendBookingConfirmation(eq("a@b.com"), any(Booking.class), eq(showtime));
    }
}
