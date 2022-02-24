package com.desmond.HotelManagement.service;

import com.desmond.HotelManagement.entity.User;

public interface UserService {
    void addUser(User user);
    User findByUsername(String username);
}
