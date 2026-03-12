package com.hotel.service.controller;

import com.hotel.service.entity.Booking;
import com.hotel.service.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getlBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        if(booking.getRoomNumber() < 1 || booking.getRoomNumber() > 9) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Room number should be between 1 and 9");
        }

        if(!bookingService.isRoomAvailable(booking.getRoomNumber(), booking.getBookingDate())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Room already booked for this date");
        }

        bookingService.createBooking(booking);

        return ResponseEntity.ok(bookingService.getAllBookings());
    }

}
