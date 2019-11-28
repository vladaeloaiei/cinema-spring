package cgm.ltw.cinema.impl.repository;

import cgm.ltw.cinema.impl.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
