package com.desmond.HotelBooking.service.impl;

import com.desmond.HotelBooking.dao.RoomDao;
import com.desmond.HotelBooking.entity.Room;
import com.desmond.HotelBooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDao roomDao;

    @Override
    public void addRoom(Room room){
        roomDao.addRoom(room);
    }

    @Override
    public List<Room> getAllRoom() {
        return roomDao.getAllRoom();
    }

    @Override
    public void updateRoom(Room room){
        roomDao.updateRoom(room);
    }

    @Override
    public void deleteRoomById(String id){
        roomDao.deleteRoomById(id);
    }
}
