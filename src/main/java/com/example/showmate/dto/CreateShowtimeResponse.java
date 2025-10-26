package com.example.showmate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@Builder
public class CreateShowtimeResponse {
   private Long id;
   private String message;

   public CreateShowtimeResponse() {
      throw new Error("Unresolved compilation problems: \n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe declared package \"com.example.MovieTicketBookingdemo.dto\" does not match the expected package \"src.main.java.com.example.MovieTicketBookingdemo.dto\"\n\tThe import com cannot be resolved\n\tThe import lombok cannot be resolved\n\tGetter cannot be resolved to a type\n\tSetter cannot be resolved to a type\n\tNoArgsConstructor cannot be resolved to a type\n\tAllArgsConstructor cannot be resolved to a type\n\tBuilder cannot be resolved to a type\n\tImplicit super constructor Object() is undefined for default constructor. Must define an explicit constructor\n\tLong cannot be resolved to a type\n\tString cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tThe method builder() is undefined for the type CreateShowtimeResponse\n");
   }

   public static <Showtime> CreateShowtimeResponse from(final Showtime var0) {
      throw new Error("Unresolved compilation problems: \n\tShowtime cannot be resolved to a type\n\tThe method builder() is undefined for the type CreateShowtimeResponse\n");
   }
}

