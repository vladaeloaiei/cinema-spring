package cgm.ltw.cinema.impl.controller;

import cgm.ltw.cinema.impl.service.BookingService;
import com.ltw.cinema.api.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping()
    public ResponseEntity<List<BookingDto>> getByScheduleId(@RequestParam("scheduleId") Long scheduleId) {
        List<BookingDto> bookingDto = bookingService.getByScheduleId(scheduleId);

        return ResponseEntity.ok(bookingDto);
    }

    @PostMapping()
    public ResponseEntity<List<BookingDto>> save(@RequestBody List<BookingDto> bookingDtos) {
        return ResponseEntity.ok(bookingDtos.stream()
                .map(bookingDto -> bookingService.save(bookingDto))
                .collect(Collectors.toList()));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody BookingDto bookingDto) {
        bookingService.delete(bookingDto);

        return ResponseEntity.ok().build();
    }
}
