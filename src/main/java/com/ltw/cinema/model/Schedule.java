package com.ltw.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SCHEDULES")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime startingAt;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
