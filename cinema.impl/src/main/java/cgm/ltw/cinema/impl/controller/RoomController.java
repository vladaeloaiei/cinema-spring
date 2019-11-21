package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.service.RoomService;
import com.ltw.cinema.api.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/rooms")
@RestController
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomDto> getById(@PathVariable("id") Long id) {
        Optional<RoomDto> roomDto = roomService.getById(id);

        return roomDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
