package com.desmond.HotelBooking.service;

import com.desmond.HotelBooking.entity.User;

public interface UserService {
    void addUser(User user);
    User findByUsername(String username);
    User findUserById(String id);
    void updateUser(User user);
    void deleteUserById(String id);
}
