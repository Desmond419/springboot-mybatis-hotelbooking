package com.desmond.HotelBooking.service.impl;

import com.desmond.HotelBooking.dao.BookingDao;
import com.desmond.HotelBooking.entity.Booking;
import com.desmond.HotelBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingDao bookingDao;

    @Override
    public void addBooking(Booking booking){
        bookingDao.addBooking(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingDao.getAllBooking();
    }

    @Override
    public List<Booking> getAllBookingByUserId(String userId) {
        return bookingDao.getAllBookingByUserId(userId);
    }

    @Override
    public void updateBooking(Booking booking){
        bookingDao.updateBooking(booking);
    }

    @Override
    public void deleteBookingById(String id){
        bookingDao.deleteBookingById(id);
    }
}
