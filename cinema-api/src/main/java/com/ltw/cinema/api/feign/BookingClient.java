package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.BookingDto;
import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "BookingClient", url = "http://localhost:8081/bookings")
public interface BookingClient {
    @GetMapping("/{id}")
    BookingDto getById(@PathVariable("id") Long id, @RequestHeader("Authorization") String bearerToken);

    @GetMapping()
    List<BookingDto> getByScheduleId(@RequestParam("scheduleId") Long scheduleId, @RequestHeader("Authorization") String bearerToken);

    @PostMapping()
    List<BookingDto> save(@RequestBody List<BookingDto> bookingDto, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping()
    void delete(@RequestBody BookingDto bookingDto, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping()//TODO??
    void deleteByEmailAndScheduleId(@RequestParam("email") String email, @RequestParam("bookingId") Long scheduleId, @RequestHeader("Authorization") String bearerToken);
}
