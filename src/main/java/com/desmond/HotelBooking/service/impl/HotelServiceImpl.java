package com.desmond.HotelBooking.service.impl;

import com.desmond.HotelBooking.dao.HotelDao;
import com.desmond.HotelBooking.entity.Hotel;
import com.desmond.HotelBooking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelDao hotelDao;

    @Override
    public void addHotel(Hotel hotel){
        hotelDao.addHotel(hotel);
    }

    @Override
    public Hotel getHotel() {
        return hotelDao.getHotel();
    }

    @Override
    public void updateHotel(Hotel hotel){
        hotelDao.updateHotel(hotel);
    }

    @Override
    public void deleteHotelById(String id){
        hotelDao.deleteHotelById(id);
    }
}
