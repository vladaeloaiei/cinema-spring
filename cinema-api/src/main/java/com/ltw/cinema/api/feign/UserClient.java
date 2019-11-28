package com.ltw.cinema.api.feign;

import com.ltw.cinema.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "UserClient", url = "http://localhost:8081/users")
public interface UserClient {
    @GetMapping("/{username}")
    boolean existsByUsername(@PathVariable("username") String username);

    @PostMapping("/login")
    UserDto login(@RequestBody UserDto userDto);

    @PostMapping()
    UserDto save(@RequestBody UserDto userDto);

    @DeleteMapping()
    void delete(@RequestBody UserDto userDto);
}
