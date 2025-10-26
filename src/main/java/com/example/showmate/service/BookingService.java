package com.example.showmate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.showmate.model.Booking;
import com.example.showmate.model.Movie;
import com.example.showmate.model.Showtime;
import com.example.showmate.repository.BookingRepository;
import com.example.showmate.repository.MovieRepository;

import java.util.List;

import com.example.showmate.model.Seat;
import com.example.showmate.repository.SeatRepository;
import com.example.showmate.repository.ShowtimeRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Service
public class BookingService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @SuppressWarnings("rawtypes")
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Showtime getShowtime(Long showtimeId) {
        return showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
    }

    @SuppressWarnings("unchecked")
    public List<Seat> getSeatsForShowtime(Showtime showtime) {
        return seatRepository.findByShowtime(showtime);
    }

    public double calculateAmount(int noOfSeats, double seatPrice) {
        return noOfSeats * seatPrice;
    }

    // After successful payment → confirm booking
    @SuppressWarnings("unchecked")
    public void confirmBooking(String email, Mode movie, Showtime showtime, List<String> seatNumbers) throws Throwable {
        for (String seatNumber : seatNumbers) {
            @SuppressWarnings("unchecked")
            Object seat = seatRepository.findBySeatNumberAndShowtime(seatNumber, showtime)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            if (((Seat) seat).isBooked()) {
                throw new RuntimeException("Seat " + ((Seat) seat).getSeatNumber() + " already booked.");
            }

            // Mark seat booked
            ((Seat) seat).setBooked(true);
            seatRepository.save(seat);

            // Save booking
            Booking booking = new Booking();
            booking.setEmail(email);
            booking.setMovie(movie);
            booking.setShowtime(showtime);
            booking.setSeat(seat);
            ((Object) booking).settotalSeats(seatNumbers.size());

            bookingRepository.save(booking);
        }
    }
}
