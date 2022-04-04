package com.desmond.HotelBooking.controller;

import com.desmond.HotelBooking.entity.Booking;
import com.desmond.HotelBooking.service.BookingService;
import com.desmond.HotelBooking.utils.GenUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBooking() {
        try {
            return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/bookings/{userId}")
    public ResponseEntity<List<Booking>> getAllBookingByUserId(@PathVariable("userId") String id) {
        try {
            return new ResponseEntity<>(bookingService.getAllBookingByUserId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/booking")
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking) {
        try {
            booking.setId(new GenUUID().getUUID());
            bookingService.addBooking(booking);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/booking")
    public ResponseEntity<Void> updateBooking(@RequestBody Booking booking) {
        try {
            bookingService.updateBooking(booking);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable("id") String id) {
        try {
            bookingService.deleteBookingById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

