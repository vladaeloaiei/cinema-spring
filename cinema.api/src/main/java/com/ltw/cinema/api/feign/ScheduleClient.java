package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ScheduleClient", url = "http://localhost:8081/schedules")
public interface ScheduleClient {
    @GetMapping("/{id}")
    ScheduleDto getById(@PathVariable("id") Long id);
}
