package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.Movie;
import cgm.ltw.cinema.impl.repository.MovieRepository;
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
}
