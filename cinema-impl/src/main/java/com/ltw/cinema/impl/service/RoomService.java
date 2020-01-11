package com.ltw.cinema.impl.service;

import com.ltw.cinema.impl.model.Room;
import com.ltw.cinema.impl.repository.RoomRepository;
import com.ltw.cinema.api.dto.RoomDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private ModelMapper modelMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository,
                       ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<RoomDto> getById(Long id) {
        Optional<Room> room = roomRepository.findById(id);

        return room.map(x -> modelMapper.map(x, RoomDto.class));
    }

    public RoomDto save(RoomDto roomDto) {
        Room savedRoom = roomRepository.save(modelMapper.map(roomDto, Room.class));

        return modelMapper.map(savedRoom, RoomDto.class);
    }

    public void delete(RoomDto roomDto) {
        roomRepository.delete(modelMapper.map(roomDto, Room.class));
    }
}
