package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.User;
import cgm.ltw.cinema.impl.repository.UserRepository;
import com.ltw.cinema.api.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UsersService(UserRepository userRepository,
                        ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public boolean existsByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        return user.isPresent();
    }

    public Optional<UserDto> login(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        return user.map(x -> modelMapper.map(x, UserDto.class));
    }

    public UserDto save(UserDto userDto) {
        User savedUser = userRepository.save(modelMapper.map(userDto, User.class));

        return modelMapper.map(savedUser, UserDto.class);
    }

    public void delete(UserDto userDto) {
        userRepository.delete(modelMapper.map(userDto, User.class));
    }
}
