package com.ltw.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private Long id;
    private LocalDateTime startingAt;
    private RoomDto roomDto;
    private MovieDto movieDto;
}
