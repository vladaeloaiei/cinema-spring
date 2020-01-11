package com.ltw.cinema.impl.service;

import com.ltw.cinema.api.dto.BookingDto;
import com.ltw.cinema.impl.model.Booking;
import com.ltw.cinema.impl.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
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

    public List<BookingDto> save(List<BookingDto> bookingDtos) {
        if (isValidBooking(bookingDtos)) {
            List<Booking> savedBookings = bookingRepository.saveAll(bookingDtos.stream()
                    .map(bookingDto -> modelMapper.map(bookingDto, Booking.class))
                    .collect(Collectors.toList()));

            return savedBookings.stream()
                    .map(booking -> modelMapper.map(booking, BookingDto.class))
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Booking overlapping");
        }
    }

    private boolean isValidBooking(List<BookingDto> bookingDtos) {
        return bookingDtos.stream()
                .noneMatch(this::existsOverlap);
    }

    private boolean existsOverlap(BookingDto bookingDto) {
        List<BookingDto> existingBookingDtos = getByRow(bookingDto.getRow());

        return existingBookingDtos.stream()
                .anyMatch(existingBookingDto -> bookingsOverlap(existingBookingDto, bookingDto));
    }

    private boolean bookingsOverlap(BookingDto existingBookingDto, BookingDto bookingDto) {
        String[] occupiedColumns = existingBookingDto.getColumns().split(",");
        String[] newColumns = bookingDto.getColumns().split(",");

        for (String occupiedColumn : occupiedColumns) {
            for (String newColumn : newColumns) {
                if (occupiedColumn.equals(newColumn)) {
                    return true;
                }
            }
        }

        return false;
    }

    private List<BookingDto> getByRow(Short row) {
        return bookingRepository.findByRow(row)
                .stream()
                .map(booking -> modelMapper.map(booking, BookingDto.class))
                .collect(Collectors.toList());
    }

    public void delete(BookingDto bookingDto) {
        bookingRepository.delete(modelMapper.map(bookingDto, Booking.class));
    }
}
