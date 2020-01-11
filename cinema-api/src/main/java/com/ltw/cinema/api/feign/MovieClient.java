package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.MovieDto;
import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "MovieClient", url = "http://localhost:8081/movies")
public interface MovieClient {
    @GetMapping("/{id}")
    MovieDto getById(@PathVariable("id") Long id, @RequestHeader("Authorization") String bearerToken);

    @PostMapping()
    MovieDto save(@RequestBody MovieDto movieDto, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping()
    void delete(@RequestBody MovieDto movieDto, @RequestHeader("Authorization") String bearerToken);
}
