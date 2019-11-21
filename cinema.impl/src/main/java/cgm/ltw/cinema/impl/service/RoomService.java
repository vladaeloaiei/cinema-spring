package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.Room;
import cgm.ltw.cinema.impl.repository.RoomRepository;
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
}
