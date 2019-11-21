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

    public Optional<UserDto> getById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(x -> modelMapper.map(x, UserDto.class));
    }
}
