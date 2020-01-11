package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "UserClient", url = "http://localhost:8081/users")
public interface UserClient {
    @GetMapping("/{username}")
    boolean existsByUsername(@PathVariable("username") String username, @RequestHeader("Authorization") String bearerToken);

    @PostMapping("/authenticate")
    String authenticate(@RequestParam("username") String username, @RequestParam("password") String password);

    @PostMapping()
    UserDto save(@RequestBody UserDto userDto, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping()
    void delete(@RequestBody UserDto userDto, @RequestHeader("Authorization") String bearerToken);
}
