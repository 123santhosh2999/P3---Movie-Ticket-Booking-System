package com.example.showmate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private String startTime;
    private double seatPrice;
    private String theaterName;
    private int seatRows;
    private int seatCols;
    public Showtime() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public double getSeatPrice() { return seatPrice; }
    public void setSeatPrice(double seatPrice) { this.seatPrice = seatPrice; }
    public String getTheaterName() { return theaterName; }
    public void setTheaterName(String theaterName) { this.theaterName = theaterName; }
    public int getSeatRows() { return seatRows; }
    public void setSeatRows(int seatRows) { this.seatRows = seatRows; }
    public int getSeatCols() { return seatCols; }
    public void setSeatCols(int seatCols) { this.seatCols = seatCols; }
}
