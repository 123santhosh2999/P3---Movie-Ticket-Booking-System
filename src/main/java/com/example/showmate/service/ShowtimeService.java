package com.example.showmate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.showmate.model.Showtime;
import com.example.showmate.repository.ShowtimeRepository;
import java.util.List;
@Service
public class ShowtimeService {
    @Autowired private ShowtimeRepository showtimeRepository;
    public List<Showtime> listByMovie(Long movieId) { return showtimeRepository.findByMovieId(movieId); }
    public Showtime create(Showtime s) { return showtimeRepository.save(s); }
    public Showtime get(Long id) { return showtimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Showtime not found")); }
}
