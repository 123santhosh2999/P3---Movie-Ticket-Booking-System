package com.example.showmate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.showmate.model.Movie;
import com.example.showmate.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void listAll_returnsRepoMovies() {
        when(movieRepository.findAll()).thenReturn(List.of(new Movie("A", "D", "P")));
        assertThat(movieService.listAll()).hasSize(1);
    }

    @Test
    void get_whenMissing_throws() {
        when(movieRepository.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> movieService.get(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Movie not found");
    }

    @Test
    void create_savesMovie() {
        Movie input = new Movie("A", "D", "P");
        Movie saved = new Movie("A", "D", "P");
        saved.setId(1L);

        when(movieRepository.save(input)).thenReturn(saved);
        assertThat(movieService.create(input).getId()).isEqualTo(1L);
    }
}
