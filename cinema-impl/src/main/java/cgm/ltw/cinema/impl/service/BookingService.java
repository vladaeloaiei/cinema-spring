package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.Booking;
import cgm.ltw.cinema.impl.repository.BookingRepository;
import com.ltw.cinema.api.dto.BookingDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository,
                          ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<BookingDto> getById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);

        return booking.map(x -> modelMapper.map(x, BookingDto.class));
    }

    public List<BookingDto> getByScheduleId(Long scheduleId) {
        List<Booking> bookings = bookingRepository.findByScheduleId(scheduleId);

        return bookings.stream()
                .map(booking -> modelMapper.map(booking, BookingDto.class))
                .collect(Collectors.toList());
    }

    public BookingDto save(BookingDto bookingDto) {
        Booking savedBooking = bookingRepository.save(modelMapper.map(bookingDto, Booking.class));

        return modelMapper.map(savedBooking, BookingDto.class);
    }

    public void delete(BookingDto bookingDto) {
        bookingRepository.delete(modelMapper.map(bookingDto, Booking.class));
    }
}
