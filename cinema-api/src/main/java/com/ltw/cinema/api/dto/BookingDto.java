package com.ltw.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private String email;
    private Short row;
    private String columns;
    private ScheduleDto schedule;
}
