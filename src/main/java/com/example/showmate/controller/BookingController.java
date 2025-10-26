package com.example.showmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController<BookingService, ShowtimeRepository, BookingRepository, JavaMailSender> {
   @Autowired
   private BookingService bookingService;
   @Autowired
   private ShowtimeRepository showtimeRepository;
   @Autowired
   private SecurityContextRepository seatRepository;
   @Autowired
   private BookingRepository bookingRepository;
   @Autowired
   private JavaMailSender mailSender;

   public BookingController() {
      throw new Error("Unresolved compilation problems: \n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe declared package \"com.example.MovieTicketBookingdemo.Controller\" does not match the expected package \"src.main.java.com.example.MovieTicketBookingdemo.Controller\"\n\tThe import com cannot be resolved\n\tThe import com cannot be resolved\n\tThe import com cannot be resolved\n\tThe import jakarta cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import java.util cannot be resolved\n\tThe import java.util cannot be resolved\n\tController cannot be resolved to a type\n\tRequestMapping cannot be resolved to a type\n\tImplicit super constructor Object() is undefined for default constructor. Must define an explicit constructor\n\tAutowired cannot be resolved to a type\n\tBookingService cannot be resolved to a type\n\tAutowired cannot be resolved to a type\n\tShowtimeRepository cannot be resolved to a type\n\tAutowired cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tAutowired cannot be resolved to a type\n\tBookingRepository cannot be resolved to a type\n\tAutowired cannot be resolved to a type\n\tJavaMailSender cannot be resolved to a type\n\tGetMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tRequestParam cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tHttpSession cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tBookingService cannot be resolved to a type\n\tList cannot be resolved to a type\n\tString cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tSeat cannot be resolved\n\tSeat cannot be resolved\n\tCollectors cannot be resolved\n\tPostMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tRequestParam cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tRequestParam cannot be resolved to a type\n\tList cannot be resolved to a type\n\tString cannot be resolved to a type\n\tHttpSession cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tBookingService cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tString cannot be resolved to a type\n\tSeat cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tRuntimeException cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tBooking cannot be resolved to a type\n\tBooking cannot be resolved to a type\n\tBookingRepository cannot be resolved to a type\n\tString cannot be resolved\n\tRuntimeException cannot be resolved to a type\n\tString cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tList cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved\n\tSimpleMailMessage cannot be resolved to a type\n\tSimpleMailMessage cannot be resolved to a type\n\tJavaMailSender cannot be resolved to a type\n\tSystem cannot be resolved\n\tException cannot be resolved to a type\n\tSystem cannot be resolved\n");
   }

   public String selectSeats(@RequestParam Long var1, HttpSession var2, Model var3) {
      throw new Error("Unresolved compilation problems: \n\tGetMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tRequestParam cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tHttpSession cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tBookingService cannot be resolved to a type\n\tList cannot be resolved to a type\n\tString cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tSeat cannot be resolved\n\tSeat cannot be resolved\n\tCollectors cannot be resolved\n");
   }

   public String confirmBooking(@RequestParam Long var1, @RequestParam List<String> var2, HttpSession var3, Model var4) {
      throw new Error("Unresolved compilation problems: \n\tPostMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tRequestParam cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tRequestParam cannot be resolved to a type\n\tList cannot be resolved to a type\n\tString cannot be resolved to a type\n\tHttpSession cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tBookingService cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tString cannot be resolved to a type\n\tSeat cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tRuntimeException cannot be resolved to a type\n\tSeatRepository cannot be resolved to a type\n\tBooking cannot be resolved to a type\n\tBooking cannot be resolved to a type\n\tBookingRepository cannot be resolved to a type\n\tString cannot be resolved\n\tRuntimeException cannot be resolved to a type\n");
   }


    public BookingService getBookingService() {
        return bookingService;
    }

    public ShowtimeRepository getShowtimeRepository() {
        return showtimeRepository;
    }

    public SecurityContextRepository getSeatRepository() {
        return seatRepository;
    }

    public BookingRepository getBookingRepository() {
        return bookingRepository;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }
}
