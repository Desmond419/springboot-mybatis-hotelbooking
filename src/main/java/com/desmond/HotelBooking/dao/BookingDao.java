package com.desmond.HotelBooking.dao;

import com.desmond.HotelBooking.entity.Booking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingDao {
    void addBooking(Booking booking);
    List<Booking> getAllBooking();
    List<Booking> getAllBookingByUserId(String userId);
    void updateBooking(Booking booking);
    void deleteBookingById(String id);
}
