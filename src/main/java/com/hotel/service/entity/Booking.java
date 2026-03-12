package com.hotel.service.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {
    private  String clientName;
    private  String phone;
    private  String email;
    private  int roomNumber;
    private  String description;
    private LocalDate bookingDate;

    public Booking(){}

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return roomNumber == booking.roomNumber && Objects.equals(clientName, booking.clientName) && Objects.equals(phone, booking.phone) && Objects.equals(email, booking.email) && Objects.equals(description, booking.description) && Objects.equals(bookingDate, booking.bookingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, phone, email, roomNumber, description, bookingDate);
    }
}
