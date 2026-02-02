package com.example.showmate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.showmate.model.Movie;
import com.example.showmate.model.Showtime;

@DataJpaTest
@ActiveProfiles("test")
class ShowtimeRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Test
    void findByMovieId_returnsShowtimes() {
        Movie movie = movieRepository.save(new Movie("T", "D", "P"));

        Showtime st = new Showtime();
        st.setMovie(movie);
        st.setStartTime("10:00");
        st.setSeatPrice(100.0);
        st.setTheaterName("Test Theater");
        st.setSeatRows(5);
        st.setSeatCols(5);
        showtimeRepository.save(st);

        List<Showtime> found = showtimeRepository.findByMovieId(movie.getId());
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getMovie().getId()).isEqualTo(movie.getId());
    }
}
