package com.example.showmate.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.showmate.model.Seat;

import java.util.List;
import java.util.Optional;


import com.example.showmate.model.Showtime;


public interface SeatRepository<seatNumber> extends JpaRepository<Seat, seatNumber> {
    List<Seat> findByShowtime(Showtime showtime);
    Optional<Seat> findBySeatNumberAndShowtime(String seatNumber, Showtime showtime);
    List<Showtime> findByTheatreName(String theatreName);
}