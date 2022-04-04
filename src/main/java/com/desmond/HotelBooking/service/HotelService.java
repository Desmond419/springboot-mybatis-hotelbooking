package com.desmond.HotelBooking.service;

import com.desmond.HotelBooking.entity.Hotel;

public interface HotelService {
    void addHotel(Hotel hotel);
    Hotel getHotel();
    void updateHotel(Hotel hotel);
    void deleteHotelById(String id);
}
