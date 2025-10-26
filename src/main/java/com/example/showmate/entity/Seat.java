package com.example.showmate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private String seatNumber;
    private String rowNumber;

    @Enumerated(EnumType.STRING)
    private SeatType type = SeatType.REGULAR;

    // Constructors
    public Seat() {}

    public Seat(Theater theater, String seatNumber, String rowNumber, SeatType type) {
        this.theater = theater;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Theater getTheater() { return theater; }
    public void setTheater(Theater theater) { this.theater = theater; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getRowNumber() { return rowNumber; }
    public void setRowNumber(String rowNumber) { this.rowNumber = rowNumber; }

    public SeatType getType() { return type; }
    public void setType(SeatType type) { this.type = type; }
}

enum SeatType {
    REGULAR, PREMIUM, VIP
}
