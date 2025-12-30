package com.example.showmate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.showmate.model.Movie;
import com.example.showmate.repository.MovieRepository;
import java.util.List;
@Service
public class MovieService {
    @Autowired private MovieRepository movieRepository;
    public List<Movie> listAll() { return movieRepository.findAll(); }
    public Movie create(Movie m) { return movieRepository.save(m); }
    public Movie get(Long id) { return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found")); }
}
