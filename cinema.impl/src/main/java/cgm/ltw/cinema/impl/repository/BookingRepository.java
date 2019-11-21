package cgm.ltw.cinema.impl.repository;

import cgm.ltw.cinema.impl.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
