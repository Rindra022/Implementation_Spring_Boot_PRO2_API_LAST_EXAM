package com.hotel.service.service;

import com.hotel.service.entity.Booking;
import com.hotel.service.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public boolean isRoomAvailable(int roomNumber, LocalDate bookingDate) {
        return !bookingRepository.existsBookingByRoomNumberAndBookingDate(roomNumber, bookingDate);
    }

    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

}
