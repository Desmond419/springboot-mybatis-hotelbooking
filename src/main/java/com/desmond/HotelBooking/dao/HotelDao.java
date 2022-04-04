package com.desmond.HotelBooking.dao;

import com.desmond.HotelBooking.entity.Hotel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelDao {
    void addHotel(Hotel hotel);
    Hotel getHotel();
    void updateHotel(Hotel hotel);
    void deleteHotelById(String id);
}
