package com.ltw.cinema.feign.it;

import com.ltw.cinema.impl.CinemaApplicationServer;
import com.ltw.cinema.api.feign.RoomClient;
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
public class RoomClientTest {
    @Configuration
    @Import({CinemaApplicationServer.class})
    public static class TestConfiguration {
    }

    @Autowired
    private RoomClient roomClient;

    @Test
    public void shouldRetrieveExistingRoomViaFeignClient() {
        assertNotNull(roomClient.getById(1L, null));
    }

    @Test
    public void shouldReceiveExceptionOnRetrievingNonExistingRoomViaFeignClient() {
        assertThrows(FeignException.class, () -> roomClient.getById(-1L, null));
    }
}
