package com.ltw.cinema.feign.it;

import cgm.ltw.cinema.impl.CinemaApplication;
import com.ltw.cinema.api.feign.MovieClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieClientTest {
    @Configuration
    @Import({CinemaApplication.class})
    public static class TestConfiguration {
    }

    @Autowired
    private MovieClient movieClient;

    @Test
    public void shouldRetrieveExistingMovieViaFeignClient() {
        assertNotNull(movieClient.getById(1L));
    }

    @Test
    public void shouldReceiveExceptionOnRetrievingNonExistingMovieViaFeignClient() {
        assertThrows(FeignException.class, () -> movieClient.getById(-1L));
    }
}
