package com.desmond.HotelBooking.dao;

import com.desmond.HotelBooking.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomDao {
    void addRoom(Room room);
    List<Room> getAllRoom();
    void updateRoom(Room room);
    void deleteRoomById(String id);
}
