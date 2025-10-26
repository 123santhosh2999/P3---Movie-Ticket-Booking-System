package com.example.showmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.qos.logback.core.model.Model;

@Controller
public class MovieController<MovieRepository, ShowtimeRepository> {
   @Autowired
   private MovieRepository movieRepo;
   @Autowired
   private ShowtimeRepository showtimeRepo;

   public MovieController() {
      throw new Error("Unresolved compilation problems: \n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files\n\tThe declared package \"com.example.MovieTicketBookingdemo.Controller\" does not match the expected package \"src.main.java.com.example.MovieTicketBookingdemo.Controller\"\n\tThe import java.util cannot be resolved\n\tThe import java.util cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import org cannot be resolved\n\tThe import com cannot be resolved\n\tThe import com cannot be resolved\n\tThe import com cannot be resolved\n\tThe import com cannot be resolved\n\tController cannot be resolved to a type\n\tRequestMapping cannot be resolved to a type\n\tImplicit super constructor Object() is undefined for default constructor. Must define an explicit constructor\n\tAutowired cannot be resolved to a type\n\tMovieRepository cannot be resolved to a type\n\tAutowired cannot be resolved to a type\n\tShowtimeRepository cannot be resolved to a type\n\tGetMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tMovieRepository cannot be resolved to a type\n\tGetMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tPathVariable cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tOptional cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tMovieRepository cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tList cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tShowtimeRepository cannot be resolved to a type\n");
   }

   @GetMapping
   public String showMovies(Model var1) {
      throw new Error("Unresolved compilation problems: \n\tGetMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tMovieRepository cannot be resolved to a type\n");
   }

   public String getMovieDetails(@PathVariable Long var1, Model var2) {
      throw new Error("Unresolved compilation problems: \n\tGetMapping cannot be resolved to a type\n\tString cannot be resolved to a type\n\tPathVariable cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tModel cannot be resolved to a type\n\tOptional cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tMovieRepository cannot be resolved to a type\n\tMovie cannot be resolved to a type\n\tList cannot be resolved to a type\n\tShowtime cannot be resolved to a type\n\tShowtimeRepository cannot be resolved to a type\n");
   }

    public MovieRepository getMovieRepo() {
        return movieRepo;
    }

    public void setShowtimeRepo(ShowtimeRepository showtimeRepo) {
        this.showtimeRepo = showtimeRepo;
    }

    public ShowtimeRepository getShowtimeRepo() {
        return showtimeRepo;
    }
}

