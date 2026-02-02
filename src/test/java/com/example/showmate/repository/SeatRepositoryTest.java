package com.example.showmate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.showmate.model.Movie;
import com.example.showmate.model.Seat;
import com.example.showmate.model.Showtime;

@DataJpaTest
@ActiveProfiles("test")
class SeatRepositoryTest {

    @Autowired private MovieRepository movieRepository;
    @Autowired private ShowtimeRepository showtimeRepository;
    @Autowired private SeatRepository seatRepository;

    @Test
    void findByShowtimeAndSeatNumberIn_returnsSeats() {
        Movie movie = movieRepository.save(new Movie("T", "D", "P"));
        Showtime st = new Showtime();
        st.setMovie(movie);
        st.setStartTime("10:00");
        st.setSeatPrice(100.0);
        st.setTheaterName("Test Theater");
        st.setSeatRows(5);
        st.setSeatCols(5);
        st = showtimeRepository.save(st);

        Seat s1 = new Seat();
        s1.setShowtime(st);
        s1.setSeatNumber("A1");
        s1.setRowNumber("A");
        s1.setColIndex(1);
        s1.setSectionName("NORMAL");
        s1.setSeatPrice(100.0);

        Seat s2 = new Seat();
        s2.setShowtime(st);
        s2.setSeatNumber("A2");
        s2.setRowNumber("A");
        s2.setColIndex(2);
        s2.setSectionName("NORMAL");
        s2.setSeatPrice(100.0);

        seatRepository.saveAll(List.of(s1, s2));

        assertThat(seatRepository.findByShowtime(st)).hasSize(2);
        assertThat(seatRepository.findByShowtimeAndSeatNumberIn(st, List.of("A2"))).hasSize(1);
    }
}
