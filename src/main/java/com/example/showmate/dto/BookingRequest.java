package com.example.showmate.dto;
import java.util.List;
public class BookingRequest {
    private String email;
    private Long movieId;
    private Long showtimeId;
    private List<String> seats;
    public BookingRequest() {}
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    public Long getShowtimeId() { return showtimeId; }
    public void setShowtimeId(Long showtimeId) { this.showtimeId = showtimeId; }
    public List<String> getSeats() { return seats; }
    public void setSeats(List<String> seats) { this.seats = seats; }
}
