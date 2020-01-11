package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value = "ScheduleClient", url = "http://localhost:8081/schedules")
public interface ScheduleClient {
    @GetMapping("/{id}")
    ScheduleDto getById(@PathVariable("id") Long id, @RequestHeader("Authorization") String bearerToken);

    @GetMapping()
    List<ScheduleDto> getAll(@RequestHeader("Authorization") String bearerToken);

    @PostMapping()
    ScheduleDto save(@RequestBody ScheduleDto scheduleDto, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping()
    void delete(@RequestBody ScheduleDto scheduleDto, @RequestHeader("Authorization") String bearerToken);
}
