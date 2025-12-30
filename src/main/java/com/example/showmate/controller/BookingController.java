package com.example.showmate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.showmate.dto.BookingRequest;
import com.example.showmate.dto.BookingResponse;
import com.example.showmate.model.Booking;
import com.example.showmate.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired private BookingService bookingService;

    @PostMapping("/confirm")
    public ResponseEntity<BookingResponse> confirm(@RequestBody BookingRequest request) {
        BookingResponse resp = new BookingResponse();
        try {
            Booking booking = bookingService.createBooking(request.getEmail(), request.getMovieId(), request.getShowtimeId(), request.getSeats());
            resp.setBookingId(booking.getId());
            resp.setStatus("SUCCESS"); resp.setMessage("Booking confirmed");
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            resp.setStatus("FAILED"); resp.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
