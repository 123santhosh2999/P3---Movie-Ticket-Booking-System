package com.example.showmate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.showmate.model.Booking;
import com.example.showmate.model.Movie;
import com.example.showmate.model.Seat;
import com.example.showmate.model.Showtime;
import com.example.showmate.repository.BookingRepository;
import com.example.showmate.repository.MovieRepository;
import com.example.showmate.repository.SeatRepository;
import com.example.showmate.repository.ShowtimeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepository;
    @Autowired private MovieRepository movieRepository;
    @Autowired private ShowtimeRepository showtimeRepository;
    @Autowired private SeatRepository seatRepository;
    @Autowired private EmailService emailService;

    @Transactional
    public Booking createBooking(String email, Long movieId, Long showtimeId, List<String> seatNumbers) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        Showtime showtime = showtimeRepository.findById(showtimeId).orElseThrow(() -> new RuntimeException("Showtime not found"));

        if (seatNumbers == null || seatNumbers.isEmpty()) {
            throw new RuntimeException("Please select at least one seat");
        }

        List<String> normalized = seatNumbers.stream()
                .filter(s -> s != null)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
        if (normalized.isEmpty()) {
            throw new RuntimeException("Please select at least one seat");
        }

        List<String> bookedSeats = new ArrayList<>();
        for (String seatNum : normalized) {
            Seat seat = seatRepository.findBySeatNumberAndShowtimeForUpdate(seatNum, showtime)
                    .orElseThrow(() -> new RuntimeException("Seat not found: " + seatNum));
            if (seat.isBooked()) throw new RuntimeException("Seat already booked: " + seatNum);
            seat.setBooked(true);
            seatRepository.save(seat);
            bookedSeats.add(seat.getSeatNumber());
        }

        Booking booking = new Booking();
        booking.setEmail(email);
        booking.setMovie(movie);
        booking.setShowtime(showtime);
        booking.setTotalSeats(bookedSeats.size());
        booking.setSeatNumbers(bookedSeats.stream().collect(Collectors.joining(", ")));
        Booking savedBooking = bookingRepository.save(booking);

        try { emailService.sendBookingConfirmation(email, savedBooking, showtime); } catch (Exception e) { System.err.println("Email error: " + e.getMessage()); }
        return savedBooking;
    }
}
