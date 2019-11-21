package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.MovieDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "MovieDetailClient", url = "http://localhost:8081/movies/details")
public interface MovieDetailClient {
    @GetMapping("/{id}")
    MovieDetailDto getById(@PathVariable("id") Long id);
}
