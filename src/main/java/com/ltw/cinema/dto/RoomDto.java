package com.ltw.cinema.dto;

import com.ltw.cinema.model.types.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private RoomType roomType;
    private Short numberOfRows;
    private Short numberOfColumns;
    private Short totalNumberOrChairs;
}
