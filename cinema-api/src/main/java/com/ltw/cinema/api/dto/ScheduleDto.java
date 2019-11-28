package com.ltw.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private Long id;
    private LocalDateTime startingAt;
    private RoomDto room;
    private MovieDto movie;
}
