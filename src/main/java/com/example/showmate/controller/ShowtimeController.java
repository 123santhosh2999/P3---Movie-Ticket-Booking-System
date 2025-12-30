package com.example.showmate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.showmate.model.Showtime;
import com.example.showmate.service.ShowtimeService;
import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {
    @Autowired private ShowtimeService showtimeService;

    @GetMapping("/movie/{movieId}") public List<Showtime> listByMovie(@PathVariable Long movieId) { return showtimeService.listByMovie(movieId); }

    @PostMapping public Showtime create(@RequestBody Showtime s) { return showtimeService.create(s); }
}
