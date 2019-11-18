package com.ltw.cinema;

import com.ltw.cinema.dto.RoomDto;
import com.ltw.cinema.model.Room;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.ltw.cinema.utils.RoomTypeConverters.roomTypeToNumberOfColumnsConverter;
import static com.ltw.cinema.utils.RoomTypeConverters.roomTypeToNumberOfRowsConverter;
import static com.ltw.cinema.utils.RoomTypeConverters.roomTypeToTotalNumberOfChairsConverter;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Bean
    ModelMapper createModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        PropertyMap<Room, RoomDto> roomPropertyMap = new PropertyMap<Room, RoomDto>() {
            protected void configure() {

                using(roomTypeToNumberOfColumnsConverter)
                        .map(source.getRoomType(), destination.getNumberOfColumns());

//                using(roomTypeToNumberOfRowsConverter)
//                        .map().setNumberOfRows(this.source("getRoomType"));
//
//                using(roomTypeToTotalNumberOfChairsConverter)
//                        .map().setTotalNumberOrChairs(source.getRoomType());
            }
        };

        modelMapper.addMappings(roomPropertyMap);
        return modelMapper;
    }


}
