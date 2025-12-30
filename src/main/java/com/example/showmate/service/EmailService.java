package com.example.showmate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.showmate.model.Booking;
import com.example.showmate.model.Showtime;

@Service
public class EmailService {
    @Autowired(required = false) private JavaMailSender mailSender;

    public void sendBookingConfirmation(String to, Booking booking, Showtime showtime) {
        if (to == null || to.isBlank() || mailSender == null) return;
        String movieTitle = (showtime != null && showtime.getMovie() != null) ? showtime.getMovie().getTitle() : "Show";
        String showTime = (showtime != null) ? showtime.getStartTime() : "N/A";
        String seats = (booking != null && booking.getSeatNumbers() != null && !booking.getSeatNumbers().isBlank()) ? booking.getSeatNumbers() : "N/A";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Booking Confirmation - " + movieTitle);
        message.setText("Your booking for " + movieTitle + " at " + showTime + " is confirmed. Seats: " + seats);
        mailSender.send(message);
    }
}
