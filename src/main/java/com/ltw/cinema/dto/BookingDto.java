package com.ltw.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private String email;
    private Short row;
    private Short column;
    private ScheduleDto scheduleDto;
}
