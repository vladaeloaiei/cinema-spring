package com.ltw.cinema.feign.it;

import com.ltw.cinema.impl.CinemaApplicationServer;
import com.ltw.cinema.api.feign.MovieDetailClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

//TODO FIX NULL
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieDetailClientTest {
    private String token;

    @Configuration
    @Import({CinemaApplicationServer.class})
    public static class TestConfiguration {
    }

    @Autowired
    private MovieDetailClient movieDetailClient;


    @Test
    public void shouldRetrieveExistingMovieDetailViaFeignClient() {
        assertNotNull(movieDetailClient.getById(1L, null));
    }

    @Test
    public void shouldReceiveExceptionOnRetrievingNonExistingMovieDetailViaFeignClient() {
        assertThrows(FeignException.class, () -> movieDetailClient.getById(-1L, null));
    }
}
