package com.example.showmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.showmate.service.MovieService;
import com.example.showmate.service.ShowtimeService;
import com.example.showmate.service.BookingService;
import com.example.showmate.service.SeatService;
import com.example.showmate.model.Movie;
import com.example.showmate.model.Showtime;
import com.example.showmate.model.Booking;
import com.example.showmate.model.Seat;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private SeatService seatService;

    @GetMapping({"/", "/index", "/home"})
    public String home(Model model) {
        List<Movie> movies = movieService.listAll();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = movieService.listAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Movie movie = movieService.get(id);
        List<Showtime> showtimes = showtimeService.listByMovie(id);
        model.addAttribute("movie", movie);
        model.addAttribute("showtimes", showtimes);
        return "movie-details";
    }

    @GetMapping("/booking/{movieId}/{showtimeId}")
    public String bookingPage(@PathVariable Long movieId, @PathVariable Long showtimeId, Model model) {
        Movie movie = movieService.get(movieId);
        Showtime showtime = showtimeService.get(showtimeId);
        model.addAttribute("movie", movie);
        model.addAttribute("showtime", showtime);
        return "booking";
    }

    @PostMapping("/booking/payment")
    public String paymentPage(@RequestParam String email,
                              @RequestParam Long movieId,
                              @RequestParam Long showtimeId,
                              @RequestParam String seats,
                              Model model) {
        Movie movie = movieService.get(movieId);
        Showtime showtime = showtimeService.get(showtimeId);

        java.util.List<String> seatList = java.util.Arrays.stream(seats.split(","))
                .map(String::trim).filter(s -> !s.isEmpty()).toList();
        if (seatList.isEmpty()) {
            model.addAttribute("error", "Please select at least one seat");
            model.addAttribute("movie", movie);
            model.addAttribute("showtime", showtime);
            return "booking";
        }

        int seatCount = seatList.size();
        double totalAmount = 0.0;
        try {
            List<Seat> seatsInDb = seatService.seatsForShowtimeAndNumbers(showtime, seatList);
            totalAmount = seatsInDb.stream().mapToDouble(s -> {
                Double p = s.getSeatPrice();
                return (p != null && p > 0) ? p : showtime.getSeatPrice();
            }).sum();
        } catch (Exception ignored) {
            totalAmount = seatCount * showtime.getSeatPrice();
        }

        model.addAttribute("movie", movie);
        model.addAttribute("showtime", showtime);
        model.addAttribute("email", email);
        model.addAttribute("seats", String.join(", ", seatList));
        model.addAttribute("seatCount", seatCount);
        model.addAttribute("totalAmount", totalAmount);
        return "payment";
    }

    @PostMapping("/booking/confirm")
    public String bookingConfirm(@RequestParam String email,
                                 @RequestParam Long movieId,
                                 @RequestParam Long showtimeId,
                                 @RequestParam String seats,
                                 Model model) {
        try {
            java.util.List<String> seatList = java.util.Arrays.stream(seats.split(","))
                    .map(String::trim).filter(s -> !s.isEmpty()).toList();
            Booking booking = bookingService.createBooking(email, movieId, showtimeId, seatList);
            model.addAttribute("booking", booking);
            return "success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("movie", movieService.get(movieId));
            model.addAttribute("showtime", showtimeService.get(showtimeId));
            return "booking";
        }
    }
}
