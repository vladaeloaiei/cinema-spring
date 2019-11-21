package cgm.ltw.cinema.impl.service;

import cgm.ltw.cinema.impl.model.Booking;
import cgm.ltw.cinema.impl.repository.BookingRepository;
import com.ltw.cinema.api.dto.BookingDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
