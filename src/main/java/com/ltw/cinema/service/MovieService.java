package com.ltw.cinema.service;

import com.ltw.cinema.dto.MovieDto;
import com.ltw.cinema.model.Movie;
import com.ltw.cinema.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MovieService(MovieRepository movieRepository,
                        ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<MovieDto> getById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        return movie.map(x -> modelMapper.map(x, MovieDto.class));
    }
}
