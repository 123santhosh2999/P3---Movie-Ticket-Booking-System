package com.example.showmate.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;



@Data
public class CreateShowtimeRequest {
   private Long movieId;
   private String theatreName;
   private String city;
   private LocalDate showDate;
   private LocalTime showTime;
   private boolean cancellationAvailable;

   public CreateShowtimeRequest() {
      throw new Error("Unresolved compilation problems: \n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe declared package \"com.example.MovieTicketBookingdemo.dto\" does not match the expected package \"src.main.java.com.example.MovieTicketBookingdemo.dto\"\n\tThe import lombok cannot be resolved\n\tThe import java.time cannot be resolved\n\tThe import java.time cannot be resolved\n\tData cannot be resolved to a type\n\tImplicit super constructor Object() is undefined for default constructor. Must define an explicit constructor\n\tLong cannot be resolved to a type\n\tString cannot be resolved to a type\n\tString cannot be resolved to a type\n\tLocalDate cannot be resolved to a type\n\tLocalTime cannot be resolved to a type\n");
   }
}
