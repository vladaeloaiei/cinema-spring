package cgm.ltw.cinema.impl.repository;

import cgm.ltw.cinema.impl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
