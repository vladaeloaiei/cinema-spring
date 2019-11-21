package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.Schedule;
import cgm.ltw.cinema.impl.repository.ScheduleRepository;
import com.ltw.cinema.api.dto.ScheduleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository,
                           ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<ScheduleDto> getById(Long id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);

        return schedule.map(x -> modelMapper.map(x, ScheduleDto.class));
    }
}
