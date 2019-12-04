package com.ltw.cinema.security.service;

import com.ltw.cinema.api.dto.UserDto;
import com.ltw.cinema.security.model.CinemaUser;
import com.ltw.cinema.security.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public boolean existsByUsername(String username) {
        Optional<CinemaUser> user = userRepository.findByUsername(username);

        return user.isPresent();
    }

    public Optional<UserDto> login(String username, String password) {
        Optional<CinemaUser> user = userRepository.findByUsernameAndPassword(username, password);

        return user.map(x -> modelMapper.map(x, UserDto.class));
    }

    public UserDto save(UserDto userDto) {
        CinemaUser savedCinemaUser = userRepository.save(modelMapper.map(userDto, CinemaUser.class));

        return modelMapper.map(savedCinemaUser, UserDto.class);
    }

    public void delete(UserDto userDto) {
        userRepository.delete(modelMapper.map(userDto, CinemaUser.class));
    }
}
