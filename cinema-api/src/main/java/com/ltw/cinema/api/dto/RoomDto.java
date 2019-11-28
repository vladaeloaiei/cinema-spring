package com.ltw.cinema.api.dto;

import com.ltw.cinema.api.types.RoomType;
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
public class RoomDto {
    private Long id;
    private RoomType roomType;
    private Short numberOfRows;
    private Short numberOfColumns;
}
