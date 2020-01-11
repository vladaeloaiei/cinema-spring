package com.ltw.cinema.impl.service;

import com.ltw.cinema.impl.model.Movie;
import com.ltw.cinema.impl.repository.MovieRepository;
import com.ltw.cinema.api.dto.MovieDto;
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

    public MovieDto save(MovieDto movieDto) {
        Movie savedMovie = movieRepository.save(modelMapper.map(movieDto, Movie.class));

        return modelMapper.map(savedMovie, MovieDto.class);
    }

    public void delete(MovieDto movieDto) {
        movieRepository.delete(modelMapper.map(movieDto, Movie.class));
    }
}
