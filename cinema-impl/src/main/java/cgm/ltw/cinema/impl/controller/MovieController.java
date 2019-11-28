package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.model.MovieDetail;
import cgm.ltw.cinema.impl.service.MovieService;
import com.ltw.cinema.api.dto.MovieDetailDto;
import com.ltw.cinema.api.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/movies")
@RestController
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable("id") Long id) {
        Optional<MovieDto> movieDto = movieService.getById(id);

        return movieDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping()
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(movieService.save(movieDto));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody MovieDto movieDto) {
        movieService.delete(movieDto);

        return ResponseEntity.ok().build();
    }
}
