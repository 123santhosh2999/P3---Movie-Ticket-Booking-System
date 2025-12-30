package com.example.showmate.config;

import com.example.showmate.model.Movie;
import com.example.showmate.model.Showtime;
import com.example.showmate.model.Seat;
import com.example.showmate.repository.MovieRepository;
import com.example.showmate.repository.ShowtimeRepository;
import com.example.showmate.repository.SeatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(
            MovieRepository movieRepository,
            ShowtimeRepository showtimeRepository,
            SeatRepository seatRepository,
            PlatformTransactionManager transactionManager) {

        return args -> {

            TransactionTemplate tx = new TransactionTemplate(transactionManager);

            if (movieRepository.count() == 0) {
                Movie m = new Movie();
                m.setTitle("Demo Movie");
                m.setDescription("A demo film");
                m.setPosterUrl("https://res.cloudinary.com/demo/image/upload/sample.jpg");
                movieRepository.save(m);

                Showtime st = new Showtime();
                st.setMovie(m);
                st.setStartTime("19:30");
                st.setSeatPrice(150.0);
                st.setTheaterName("PVR - Screen 1");
                st.setSeatRows(8);
                st.setSeatCols(10);
                showtimeRepository.save(st);

                System.out.println("Seeded demo movie.");
            }

            // Seed extra theaters/timings for each movie (Option A) if missing.
            List<Movie> movies = movieRepository.findAll();
            for (Movie movie : movies) {
                createShowtimeIfMissing(showtimeRepository, movie, "PVR - Screen 1", "10:30 AM", 150.0, 8, 10);
                createShowtimeIfMissing(showtimeRepository, movie, "INOX - Screen 2", "2:30 PM", 170.0, 10, 12);
                createShowtimeIfMissing(showtimeRepository, movie, "Cinepolis - Screen 3", "6:45 PM", 200.0, 6, 8);
            }

            // Ensure showtimes have theater/layout set and seats generated in a multi-row grid.
            List<Showtime> allShowtimes = showtimeRepository.findAll();
            for (Showtime st : allShowtimes) {
                if (st.getTheaterName() == null || st.getTheaterName().isBlank()) {
                    st.setTheaterName("PVR - Screen 1");
                }
                if (st.getSeatRows() <= 0) {
                    st.setSeatRows(8);
                }
                if (st.getSeatCols() <= 0) {
                    st.setSeatCols(10);
                }
                showtimeRepository.save(st);

                List<Seat> existing = seatRepository.findByShowtime(st);
                boolean needsRegen = existing.isEmpty() || existing.stream().anyMatch(s ->
                        s.getSectionName() == null || s.getSectionName().isBlank() ||
                                s.getColIndex() == null || s.getColIndex() <= 0);
                if (needsRegen) {
                    tx.executeWithoutResult(status -> {
                        seatRepository.deleteAllByShowtime(st);
                        seatRepository.saveAll(generateBookMyShowLayoutSeats(st));
                    });
                }
            }
        };
    }

    private List<Seat> generateBookMyShowLayoutSeats(Showtime st) {
        // Template similar to the screenshot: 3 sections with different prices and aisles.
        // colIndex controls horizontal placement; missing colIndex positions become gaps.
        List<Seat> seats = new ArrayList<>();

        // Section definitions
        addSection(seats, st, "PREMIUM", 250.0, List.of("K", "L"), 22,
                Set.of(3, 7, 19), // aisles
                Set.of(1,2,4,5,6,8,9,10,11,12,13,14,15,16,17,18,20,21,22));

        addSection(seats, st, "EXECUTIVE", 230.0, List.of("F", "G", "H", "I", "J"), 22,
                Set.of(3, 7, 19),
                Set.of(1,2,4,5,6,8,9,10,11,12,13,14,15,16,17,18,20,21,22));

        addSection(seats, st, "NORMAL", 210.0, List.of("A", "B", "C", "D", "E"), 22,
                Set.of(6, 16),
                Set.of(1,2,3,4,5,7,8,9,10,11,12,13,14,15,17,18,19,20,21,22));

        return seats;
    }

    private void addSection(List<Seat> out,
                            Showtime st,
                            String sectionName,
                            double price,
                            List<String> rows,
                            int maxCol,
                            Set<Integer> aisles,
                            Set<Integer> usedCols) {
        // seats will be created only for usedCols; any missing columns act as gaps/aisles.
        for (String row : rows) {
            for (int col = 1; col <= maxCol; col++) {
                if (aisles.contains(col)) continue;
                if (!usedCols.contains(col)) continue;
                Seat s = new Seat();
                s.setShowtime(st);
                s.setSectionName(sectionName);
                s.setSeatPrice(price);
                s.setRowNumber(row);
                s.setColIndex(col);
                s.setSeatNumber(row + col);
                s.setBooked(false);
                out.add(s);
            }
        }
    }

    private void createShowtimeIfMissing(ShowtimeRepository showtimeRepository,
                                         Movie movie,
                                         String theaterName,
                                         String startTime,
                                         double seatPrice,
                                         int seatRows,
                                         int seatCols) {
        boolean exists = showtimeRepository.findByMovieId(movie.getId()).stream()
                .anyMatch(s -> startTime.equals(s.getStartTime()) && theaterName.equals(s.getTheaterName()));
        if (exists) return;

        Showtime st = new Showtime();
        st.setMovie(movie);
        st.setStartTime(startTime);
        st.setSeatPrice(seatPrice);
        st.setTheaterName(theaterName);
        st.setSeatRows(seatRows);
        st.setSeatCols(seatCols);
        showtimeRepository.save(st);
    }
}
