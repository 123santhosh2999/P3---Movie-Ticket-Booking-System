package com.example.showmate.controller;

import com.example.showmate.dto.SeatStatusDto;
import com.example.showmate.model.Seat;
import com.example.showmate.model.Showtime;
import com.example.showmate.service.SeatService;
import com.example.showmate.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatApiController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping("/showtime/{showtimeId}")
    public List<SeatStatusDto> seatsByShowtime(@PathVariable Long showtimeId) {
        Showtime showtime = showtimeService.get(showtimeId);
        List<Seat> seats = seatService.seatsForShowtime(showtime);
        return seats.stream()
                .map(s -> new SeatStatusDto(
                        s.getSeatNumber(),
                        s.getRowNumber(),
                        s.getSectionName(),
                        s.getColIndex() == null ? 0 : s.getColIndex(),
                        s.getSeatPrice() == null ? 0.0 : s.getSeatPrice(),
                        s.isBooked()))
                .toList();
    }
}
