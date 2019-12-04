package com.ltw.cinema.security.configuration;

import com.ltw.cinema.security.model.CinemaUser;
import com.ltw.cinema.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private UserRepository userRepository;

    @Autowired
    public CustomAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        return userRepository.findByUsernameAndPassword(username, password)
                .map(this::createAuthentication)
                .orElse(null);
    }

    private UsernamePasswordAuthenticationToken createAuthentication(CinemaUser cinemaUser) {
        String username = cinemaUser.getUsername();
        String password = cinemaUser.getPassword();
        GrantedAuthority role = new SimpleGrantedAuthority(cinemaUser.getUserRole().toString());
        return new UsernamePasswordAuthenticationToken(username, password, Collections.singletonList(role));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
