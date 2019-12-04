package cgm.ltw.cinema.impl;

import cgm.ltw.cinema.impl.model.Booking;
import cgm.ltw.cinema.impl.model.Movie;
import cgm.ltw.cinema.impl.model.MovieDetail;
import cgm.ltw.cinema.impl.model.Room;
import cgm.ltw.cinema.impl.model.Schedule;
import cgm.ltw.cinema.impl.repository.BookingRepository;
import cgm.ltw.cinema.impl.repository.MovieDetailRepository;
import cgm.ltw.cinema.impl.repository.MovieRepository;
import cgm.ltw.cinema.impl.repository.RoomRepository;
import cgm.ltw.cinema.impl.repository.ScheduleRepository;
import com.ltw.cinema.security.model.CinemaUser;
import com.ltw.cinema.security.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.ltw.cinema.security"})
@EnableFeignClients(basePackages = "com.ltw.cinema.api.feign")
@EntityScan(basePackageClasses = {
        Booking.class,
        Movie.class,
        MovieDetail.class,
        Room.class,
        Schedule.class,
        CinemaUser.class
})
@EnableJpaRepositories(basePackageClasses = {
        BookingRepository.class,
        MovieRepository.class,
        MovieDetailRepository.class,
        RoomRepository.class,
        ScheduleRepository.class,
        UserRepository.class
})
public class CinemaApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplicationServer.class, args);
    }

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
