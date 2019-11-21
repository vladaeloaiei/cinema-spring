package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.BookingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "BookingClient", url = "https://localhost:8081/bookings")
public interface BookingClient {
    @GetMapping("/{id}")
    BookingDto getById(@PathVariable("id") Long id);
}
