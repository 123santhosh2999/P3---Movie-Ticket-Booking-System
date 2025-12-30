package com.example.showmate.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.showmate.model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {}
