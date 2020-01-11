package com.ltw.cinema.feign.it;

import com.ltw.cinema.impl.CinemaApplicationServer;
import com.ltw.cinema.api.feign.ScheduleClient;
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
public class ScheduleClientTest {
    @Configuration
    @Import({CinemaApplicationServer.class})
    public static class TestConfiguration {
    }

    @Autowired
    private ScheduleClient scheduleClient;

    @Test
    public void shouldRetrieveExistingScheduleViaFeignClient() {
        assertNotNull(scheduleClient.getById(1L, null));
    }

    @Test
    public void shouldReceiveExceptionOnRetrievingNonExistingScheduleViaFeignClient() {
        assertThrows(FeignException.class, () -> scheduleClient.getById(-1L, null));
    }
}
