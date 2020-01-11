package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.RoomDto;
import com.ltw.cinema.api.dto.ScheduleDto;
import com.ltw.cinema.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "RoomClient", url = "http://localhost:8081/rooms")
public interface RoomClient {
    @GetMapping("/{id}")
    RoomDto getById(@PathVariable("id") Long id, @RequestHeader("Authorization") String bearerToken);

    @PostMapping()
    RoomDto save(@RequestBody RoomDto roomDto, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping()
    void delete(@RequestBody RoomDto roomDto, @RequestHeader("Authorization") String bearerToken);
}
