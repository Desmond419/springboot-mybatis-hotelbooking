package com.desmond.HotelBooking.dao;

import com.desmond.HotelBooking.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void addUser(User user);
    User findByUserEmail(String username);
    User findUserById(String id);
    void updateUser(User user);
    void deleteUserById(String id);
}
