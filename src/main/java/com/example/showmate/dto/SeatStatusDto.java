package com.example.showmate.dto;

public class SeatStatusDto {
    private String seatNumber;
    private String rowNumber;
    private String sectionName;
    private int colIndex;
    private double seatPrice;
    private boolean booked;

    public SeatStatusDto() {}

    public SeatStatusDto(String seatNumber, String rowNumber, String sectionName, int colIndex, double seatPrice, boolean booked) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.sectionName = sectionName;
        this.colIndex = colIndex;
        this.seatPrice = seatPrice;
        this.booked = booked;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
