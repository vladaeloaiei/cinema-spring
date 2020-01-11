package com.ltw.cinema.impl.service;

import com.ltw.cinema.impl.model.Schedule;
import com.ltw.cinema.impl.repository.ScheduleRepository;
import com.ltw.cinema.api.dto.ScheduleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ScheduleDto save(ScheduleDto scheduleDto) {
        Schedule savedSchedule = scheduleRepository.save(modelMapper.map(scheduleDto, Schedule.class));

        return modelMapper.map(savedSchedule, ScheduleDto.class);
    }

    public void delete(ScheduleDto scheduleDto) {
        scheduleRepository.delete(modelMapper.map(scheduleDto, Schedule.class));
    }

    public List<ScheduleDto> getAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules.stream()
                .map(x -> modelMapper.map(x, ScheduleDto.class))
                .collect(Collectors.toList());
    }
}
