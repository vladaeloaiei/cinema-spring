package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "MovieClient", url = "http://localhost:8081/movies")
public interface MovieClient {
    @GetMapping("/{id}")
    MovieDto getById(@PathVariable("id") Long id);
}
