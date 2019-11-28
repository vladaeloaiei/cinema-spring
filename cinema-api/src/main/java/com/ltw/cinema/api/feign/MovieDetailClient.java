package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.MovieDetailDto;
import com.ltw.cinema.api.dto.MovieDto;
import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MovieDetailClient", url = "http://localhost:8081/movies/details")
public interface MovieDetailClient {
    @GetMapping("/{id}")
    MovieDetailDto getById(@PathVariable("id") Long id);

    @GetMapping
    MovieDetailDto getByMovieId(@RequestParam("movieId") Long movieId);

    @PostMapping()
    MovieDetailDto save(@RequestBody MovieDetailDto movieDetailDto);

    @DeleteMapping()
    void delete(@RequestBody MovieDetailDto movieDetailDto);
}
