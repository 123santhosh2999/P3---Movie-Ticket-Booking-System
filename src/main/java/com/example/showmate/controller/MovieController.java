package com.example.showmate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.showmate.model.Movie;
import com.example.showmate.service.MovieService;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired private MovieService movieService;

    @GetMapping public List<Movie> list() { return movieService.listAll(); }

    @PostMapping(consumes = {"application/x-www-form-urlencoded","multipart/form-data"})
    public Movie createForm(Movie m) { return movieService.create(m); }

    @PostMapping(consumes = "application/json")
    public Movie createJson(@RequestBody Movie m) { return movieService.create(m); }
}
