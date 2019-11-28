package com.ltw.cinema.api.dto;

import com.ltw.cinema.api.types.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private UserRole userRole;

    public UserDto(String username,
                   String password) {
        this.username = username;
        this.password = password;
    }
}
