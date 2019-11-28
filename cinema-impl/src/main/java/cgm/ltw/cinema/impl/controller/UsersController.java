package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.service.UsersService;
import com.ltw.cinema.api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("{username}")
    public ResponseEntity<Boolean> getById(@PathVariable("username") String username) {
        Boolean exists = usersService.existsByUsername(username);

        return ResponseEntity.ok(exists);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        Optional<UserDto> loggedUserDto = usersService.login(userDto.getUsername(), userDto.getPassword());

        return loggedUserDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(usersService.save(userDto));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody UserDto userDto) {
        usersService.delete(userDto);

        return ResponseEntity.ok().build();
    }
}
