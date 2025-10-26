package com.example.showmate.service;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.showmate.model.Showtime;

import java.util.List;

@Service
public class EmailService<JavaMailSender> {

    @Autowired
    private JavaMailSender mailSender;
    private String seatNumber;
    private String busNumber;
    private String departureTime;

    public void sendBookingEmail(String to, Showtime showtime, List<String> seats) {
       SimpleMessage emailMessage = new SimpleMessage();
     emailMessage.setTo("user@example.com");   // ✅ Works fine
       emailMessage.setSubject("Test Email");
       emailMessage.setText("This is a test.");


       "Your booking is confirmed!\n\n" +
      "Seat Number: " + seatNumber + "\n" +
     "Bus Number: " + busNumber + "\n" +
      "Departure: " + departureTime + "\n" +
    

 

        
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }
}