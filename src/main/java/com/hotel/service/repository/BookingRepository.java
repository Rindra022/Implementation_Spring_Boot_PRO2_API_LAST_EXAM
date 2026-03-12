package com.hotel.service.repository;

import com.hotel.service.entity.Booking;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {

    private final List<Booking> bookings = new ArrayList<>();

    public List<Booking> findAll() {
        return bookings;
    }

    public void save(Booking booking){
        bookings.add(booking);
    }

    public boolean existsBookingByRoomNumberAndBookingDate(int roomNumber, LocalDate bookingDate){
        return bookings.stream()
                .anyMatch(b -> b.getRoomNumber() == roomNumber &&
                        b.getBookingDate().equals(bookingDate));
    }
}
