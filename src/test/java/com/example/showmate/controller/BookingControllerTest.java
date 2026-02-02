package com.example.showmate.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.showmate.model.Booking;
import com.example.showmate.service.BookingService;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Test
    void confirm_success() throws Exception {
        Booking booking = new Booking();
        booking.setId(123L);

        when(bookingService.createBooking(
                org.mockito.ArgumentMatchers.anyString(),
                org.mockito.ArgumentMatchers.anyLong(),
                org.mockito.ArgumentMatchers.anyLong(),
                org.mockito.ArgumentMatchers.anyList()))
                .thenReturn(booking);

        mockMvc.perform(post("/api/bookings/confirm")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"a@b.com\",\"movieId\":1,\"showtimeId\":2,\"seats\":[\"A1\",\"A2\"]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.bookingId").value(123))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Booking confirmed")));
    }

    @Test
    void confirm_failure_returnsBadRequest() throws Exception {
        when(bookingService.createBooking(
                org.mockito.ArgumentMatchers.anyString(),
                org.mockito.ArgumentMatchers.anyLong(),
                org.mockito.ArgumentMatchers.anyLong(),
                org.mockito.ArgumentMatchers.anyList()))
                .thenThrow(new RuntimeException("Seat already booked: A1"));

        mockMvc.perform(post("/api/bookings/confirm")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"a@b.com\",\"movieId\":1,\"showtimeId\":2,\"seats\":[\"A1\"]}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Seat already booked")));
    }
}
