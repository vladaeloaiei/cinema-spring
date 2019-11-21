package com.ltw.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailDto {
    private Long id;
    private LocalDate launchDate;
    private String movieType;
    private String description;
    private MovieDto movie;
}
