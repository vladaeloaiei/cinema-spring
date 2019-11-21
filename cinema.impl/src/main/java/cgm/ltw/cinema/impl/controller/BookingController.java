package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.service.BookingService;
import com.ltw.cinema.api.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/bookings")
@RestController
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDto> getById(@PathVariable("id") Long id) {
        Optional<BookingDto> bookingDto = bookingService.getById(id);

        return bookingDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
