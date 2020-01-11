package com.ltw.cinema.impl.repository;

import com.ltw.cinema.impl.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByScheduleId(Long scheduleId);

    List<Booking> findByRow(Short row);
}
