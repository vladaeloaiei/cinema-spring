package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "ScheduleClient", url = "http://localhost:8081/schedules")
public interface ScheduleClient {
    @GetMapping("/{id}")
    ScheduleDto getById(@PathVariable("id") Long id);

    @GetMapping()
    List<ScheduleDto> getAll();

    @PostMapping()
    ScheduleDto save(@RequestBody ScheduleDto scheduleDto);

    @DeleteMapping()
    void delete(@RequestBody ScheduleDto scheduleDto);
}
