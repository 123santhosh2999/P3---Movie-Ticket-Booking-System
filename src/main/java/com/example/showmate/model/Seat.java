package com.example.showmate.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "seats",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_seat_showtime_number", columnNames = {"showtime_id", "seat_number"})
        }
)
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "row_no")
    private String rowNumber;
    @Column(name = "section_name")
    private String sectionName;
    @Column(name = "col_index")
    private Integer colIndex;
    private Double seatPrice;
    private boolean booked = false;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;
    public Seat() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getRowNumber() { return rowNumber; }
    public void setRowNumber(String rowNumber) { this.rowNumber = rowNumber; }
    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }
    public Integer getColIndex() { return colIndex; }
    public void setColIndex(Integer colIndex) { this.colIndex = colIndex; }
    public Double getSeatPrice() { return seatPrice; }
    public void setSeatPrice(Double seatPrice) { this.seatPrice = seatPrice; }
    public boolean isBooked() { return booked; }
    public void setBooked(boolean booked) { this.booked = booked; }
    public Showtime getShowtime() { return showtime; }
    public void setShowtime(Showtime showtime) { this.showtime = showtime; }
}
