package com.ltw.cinema.security.service;

import com.ltw.cinema.security.util.JwtUtil;
import com.ltw.cinema.security.util.SecurityConstants;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    @Autowired
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);

        if (isValidToken(token)) {
            return getAuthenticationFromToken(token);
        } else {
            throw new RuntimeException("Token does not exist"); //TODO
        }
    }

    private boolean isValidToken(String token) {
        return Objects.nonNull(token) && token.startsWith(SecurityConstants.TOKEN_PREFIX);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationFromToken(String token) {
        Pair<String, List<GrantedAuthority>> userDetails = JwtUtil.parseToken(token);
        return new UsernamePasswordAuthenticationToken(userDetails.getKey(), null, userDetails.getValue());
    }
}
