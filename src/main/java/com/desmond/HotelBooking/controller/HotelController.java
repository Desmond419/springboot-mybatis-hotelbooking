package com.desmond.HotelBooking.controller;

import com.desmond.HotelBooking.entity.Hotel;
import com.desmond.HotelBooking.service.HotelService;
import com.desmond.HotelBooking.utils.GenUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public ResponseEntity<Hotel> getHotel() {
        try{
            return new ResponseEntity<>(hotelService.getHotel(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/hotel")
    public ResponseEntity<Void> addHotel(@RequestBody Hotel hotel) {
        try{
            hotel.setId(new GenUUID().getUUID());
            hotelService.addHotel(hotel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hotel")
    public ResponseEntity<Void> updateHotel(@RequestBody Hotel hotel) {
        try{
            hotelService.updateHotel(hotel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable("id") String id) {
        try{
            hotelService.deleteHotelById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
