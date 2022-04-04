package com.desmond.HotelBooking.controller;

import com.desmond.HotelBooking.entity.Room;
import com.desmond.HotelBooking.service.RoomService;
import com.desmond.HotelBooking.utils.GenUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRoom() {
        try {
            return new ResponseEntity<>(roomService.getAllRoom(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/room")
    public ResponseEntity<Void> addRoom(@RequestBody Room room) {
        try {
            room.setId(new GenUUID().getUUID());
            roomService.addRoom(room);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/room")
    public ResponseEntity<Void> updateRoom(@RequestBody Room room) {
        try {
            roomService.updateRoom(room);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable("id") String id) {
        try {
            roomService.deleteRoomById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
