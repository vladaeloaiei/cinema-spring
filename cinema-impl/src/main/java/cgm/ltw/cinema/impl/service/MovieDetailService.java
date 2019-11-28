package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.MovieDetail;
import cgm.ltw.cinema.impl.repository.MovieDetailRepository;
import com.ltw.cinema.api.dto.MovieDetailDto;
import com.ltw.cinema.api.dto.MovieDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieDetailService {
    private MovieDetailRepository movieDetailRepository;
    private MovieService movieService;
    private ModelMapper modelMapper;

    @Autowired
    public MovieDetailService(MovieDetailRepository movieDetailRepository,
                              MovieService movieService,
                              ModelMapper modelMapper) {
        this.movieDetailRepository = movieDetailRepository;
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    public Optional<MovieDetailDto> getById(Long id) {
        Optional<MovieDetail> movieDetail = movieDetailRepository.findById(id);

        return movieDetail.map(x -> modelMapper.map(x, MovieDetailDto.class));
    }

    public Optional<MovieDetailDto> getByMovieId(Long movieId) {
        //Optional<MovieDto> movieDto = movieService.getById(movieId); TODO
        Optional<MovieDetail> movieDetail = movieDetailRepository.findByMovieId(movieId);

        return movieDetail.map(x -> modelMapper.map(x, MovieDetailDto.class));
    }

    public MovieDetailDto save(MovieDetailDto movieDetailDto) {
        MovieDetail savedMovieDetail = movieDetailRepository.save(modelMapper.map(movieDetailDto, MovieDetail.class));

        return modelMapper.map(savedMovieDetail, MovieDetailDto.class);
    }

    public void delete(MovieDetailDto movieDetailDto) {
        movieDetailRepository.delete(modelMapper.map(movieDetailDto, MovieDetail.class));
    }
}
