package com.example.showmate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.showmate.model.Movie;

@DataJpaTest
@ActiveProfiles("test")
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void saveAndFindAll() {
        movieRepository.save(new Movie("T1", "D1", "P1"));
        movieRepository.save(new Movie("T2", "D2", "P2"));

        assertThat(movieRepository.findAll()).hasSizeGreaterThanOrEqualTo(2);
    }
}
