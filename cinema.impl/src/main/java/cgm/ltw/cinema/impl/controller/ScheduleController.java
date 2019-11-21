package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.service.ScheduleService;
import com.ltw.cinema.api.dto.ScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/schedules")
@RestController
public class ScheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ScheduleDto> getById(@PathVariable("id") Long id) {
        Optional<ScheduleDto> scheduleDto = scheduleService.getById(id);

        return scheduleDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
