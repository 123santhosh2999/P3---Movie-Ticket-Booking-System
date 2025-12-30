package com.example.showmate.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.persistence.LockModeType;
import com.example.showmate.model.Seat;
import com.example.showmate.model.Showtime;
import java.util.List;
import java.util.Optional;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowtime(Showtime showtime);
    Optional<Seat> findBySeatNumberAndShowtime(String seatNumber, Showtime showtime);

    List<Seat> findByShowtimeAndSeatNumberIn(Showtime showtime, List<String> seatNumbers);

    @Modifying
    @Query("delete from Seat s where s.showtime = :showtime")
    void deleteAllByShowtime(@Param("showtime") Showtime showtime);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Seat s where s.seatNumber = :seatNumber and s.showtime = :showtime")
    Optional<Seat> findBySeatNumberAndShowtimeForUpdate(
            @Param("seatNumber") String seatNumber,
            @Param("showtime") Showtime showtime);
}
