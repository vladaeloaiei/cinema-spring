package com.ltw.cinema.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil implements Serializable {
    private static final String TOKEN_ROLES = "roles";

    @Value("${keystore/jwt_secret.key}")
    private static String secretKey;

    public static String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                //.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE) TODO
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .claim("roles", roles)
                .compact();
    }

    public static Pair<String, List<GrantedAuthority>> parseToken(String bearerToken) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(bearerToken.replace("Bearer ", ""));
        String username = jws.getBody().getSubject();
        List<GrantedAuthority> roles = ((List<?>) jws.getBody().get(TOKEN_ROLES)).stream()
                .map(authority -> new SimpleGrantedAuthority((String) authority))
                .collect(Collectors.toList());

        return new Pair<>(username, roles);
    }

    private JwtUtil() {
        throw new IllegalStateException("Can not instantiate this class");
    }
}
