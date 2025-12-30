package com.example.showmate.dto;
public class BookingResponse {
    private Long bookingId;
    private String status;
    private String message;
    public BookingResponse() {}
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
