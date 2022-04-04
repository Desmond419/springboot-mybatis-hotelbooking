package com.desmond.HotelBooking.service;

import com.desmond.HotelBooking.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    List<Room> getAllRoom();
    void updateRoom(Room room);
    void deleteRoomById(String id);
}
