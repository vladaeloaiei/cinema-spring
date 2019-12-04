package com.ltw.cinema.security.controller;

import com.ltw.cinema.api.dto.UserDto;
import com.ltw.cinema.security.service.UserService;
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
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{username}")
    public ResponseEntity<Boolean> getById(@PathVariable("username") String username) {
        Boolean exists = userService.existsByUsername(username);

        return ResponseEntity.ok(exists);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        Optional<UserDto> loggedUserDto = userService.login(userDto.getUsername(), userDto.getPassword());

        return loggedUserDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody UserDto userDto) {
        userService.delete(userDto);

        return ResponseEntity.ok().build();
    }
}
