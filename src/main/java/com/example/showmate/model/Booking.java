package com.example.showmate.model;


import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private int totalSeat;

    @ManyToOne
    private Mode movie;

    @ManyToOne
    private Showtime showtime;

    @ManyToOne
    private Object seat;
    private int totalSeats;

    // ---------- Constructors ----------
    public Booking() {}

    public Booking(Long id, String email, int totalSeats, Mode movie, Showtime showtime, Seat seat) {
        this.id = id;
        this.email = email;
        this.totalSeats= totalSeats;
        this.movie = movie;
        this.showtime = showtime;
        this.seat = seat;
    }
    
    

    // ---------- Getters ----------
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int gettotalSeat() {
        return totalSeat;
    }

    public Mode getMovie() {
        return movie;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Object getSeat() {
        return seat;
    }

    // ---------- Setters ----------
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void settotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public void setMovie(Mode movie2) {
        this.movie = movie2;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setSeat(Object seat2) {
        this.seat = seat2;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getTotalSeat() {
        return totalSeat;
    }
}