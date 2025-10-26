package com.example.showmate.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.showmate.repository.SeatRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {

    private SeatRepository showTimeRepository = null;

    public void ShowTimeService(@SuppressWarnings("rawtypes") SeatRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    // Create or update a showtime
    public Object saveShowTime(ShowtimeService showTime) {
        return showTimeRepository.save(showTime);
    }

    // Fetch all showtimes
    public List<ShowtimeService> getAllShowTimes() {
        return showTimeRepository.findAll();
    }

    // Fetch showtime by ID
    public Optional<ShowtimeService> getShowTimeById(Long id) {
        return showTimeRepository.findById(id);
    }

    // Delete showtime
    public void deleteShowTime(Long id) {
        showTimeRepository.deleteById(id);
    }

    // Filter by movie name
    public List<ShowtimeService> getShowTimesByMovie(String movieName) {
        return showTimeRepository.findByTheatreName(movieName);
    }

    // Filter by theatre name
    public List<ShowtimeService> getShowTimesByTheatre(String theatreName) {
        return showTimeRepository.findByTheatreName(theatreName);
    }

    // Filter by upcoming shows
    @Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByShowDateTimeAfter(LocalDateTime dateTime);
}

    }


