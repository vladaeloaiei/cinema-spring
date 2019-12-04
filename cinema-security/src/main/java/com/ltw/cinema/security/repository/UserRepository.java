package com.ltw.cinema.security.repository;

import com.ltw.cinema.security.model.CinemaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CinemaUser, Long> {
    Optional<CinemaUser> findByUsername(String username);

    Optional<CinemaUser> findByUsernameAndPassword(String username, String password);
}
