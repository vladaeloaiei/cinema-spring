package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "RoomClient", url = "http://localhost:8081/rooms")
public interface RoomClient {
    @GetMapping("/{id}")
    RoomDto getById(@PathVariable("id") Long id);
}
