package com.example.showmate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.showmate.model.Seat;
import com.example.showmate.model.Showtime;
import com.example.showmate.repository.SeatRepository;
import java.util.List;
@Service
public class SeatService {
    @Autowired private SeatRepository seatRepository;
    public List<Seat> seatsForShowtime(Showtime showtime) { return seatRepository.findByShowtime(showtime); }

    public List<Seat> seatsForShowtimeAndNumbers(Showtime showtime, List<String> seatNumbers) {
        return seatRepository.findByShowtimeAndSeatNumberIn(showtime, seatNumbers);
    }

    public void replaceSeatsForShowtime(Showtime showtime, List<Seat> seats) {
        seatRepository.deleteAllByShowtime(showtime);
        seatRepository.saveAll(seats);
    }
}
