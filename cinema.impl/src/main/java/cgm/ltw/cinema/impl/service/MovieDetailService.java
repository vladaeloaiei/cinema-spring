package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.MovieDetail;
import cgm.ltw.cinema.impl.repository.MovieDetailRepository;
import com.ltw.cinema.api.dto.MovieDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieDetailService {
    private MovieDetailRepository movieDetailRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MovieDetailService(MovieDetailRepository movieDetailRepository,
                              ModelMapper modelMapper) {
        this.movieDetailRepository = movieDetailRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<MovieDetailDto> getById(Long id) {
        Optional<MovieDetail> movieDetail = movieDetailRepository.findById(id);

        return movieDetail.map(x -> modelMapper.map(x, MovieDetailDto.class));
    }
}
