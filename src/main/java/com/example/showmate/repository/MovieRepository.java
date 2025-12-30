package com.example.showmate.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.showmate.model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {}
