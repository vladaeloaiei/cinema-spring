package com.ltw.cinema.feign.it;

import com.ltw.cinema.impl.CinemaApplicationServer;
import com.ltw.cinema.api.feign.BookingClient;
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
public class BookingClientTest {
    @Configuration
    @Import({CinemaApplicationServer.class})
    public static class TestConfiguration {
    }

    @Autowired
    private BookingClient bookingClient;

    @Test
    public void shouldRetrieveExistingBookingViaFeignClient() {
        assertNotNull(bookingClient.getById(1L, null));
    }

    @Test
    public void shouldReceiveExceptionOnRetrievingNonExistingBookingViaFeignClient() {
        assertThrows(FeignException.class, () -> bookingClient.getById(-1L, null));
    }
}
