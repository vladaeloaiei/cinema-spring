package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.service.MovieDetailService;
import com.ltw.cinema.api.dto.MovieDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/movies/details")
@RestController
public class MovieDetailController {
    private MovieDetailService movieDetailService;

    @Autowired
    public MovieDetailController(MovieDetailService movieDetailService) {
        this.movieDetailService = movieDetailService;
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDetailDto> getById(@PathVariable("id") Long id) {
        Optional<MovieDetailDto> movieDetailDto = movieDetailService.getById(id);

        return movieDetailDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
