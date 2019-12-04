package com.ltw.cinema.security.util;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/authenticate";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final Integer TOKEN_VALIDITY = 5 * 60 * 60 * 1000; // millis

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
