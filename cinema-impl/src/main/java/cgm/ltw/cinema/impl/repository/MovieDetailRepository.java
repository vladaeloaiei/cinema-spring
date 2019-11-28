package cgm.ltw.cinema.impl.repository;

import cgm.ltw.cinema.impl.model.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieDetailRepository extends JpaRepository<MovieDetail, Long> {
    Optional<MovieDetail> findByMovieId(Long movieId);
}
