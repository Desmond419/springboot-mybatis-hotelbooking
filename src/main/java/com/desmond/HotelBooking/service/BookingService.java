package com.desmond.HotelBooking.service;

import com.desmond.HotelBooking.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookingService {
    void addBooking(Booking booking);
    List<Booking> getAllBooking();
    List<Booking> getAllBookingByUserId(String userId);
    void updateBooking(Booking booking);
    void deleteBookingById(String id);
}
