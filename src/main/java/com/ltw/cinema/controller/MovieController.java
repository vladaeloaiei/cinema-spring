package com.ltw.cinema.controller;

import com.ltw.cinema.dto.MovieDto;
import com.ltw.cinema.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController(value = "movies")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id) {
        Optional<MovieDto> movie = movieService.getById(id);

        return movie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
