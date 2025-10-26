package com.example.showmate.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.showmate.model.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieId(Long id); // ✅ matches MovieController
}
