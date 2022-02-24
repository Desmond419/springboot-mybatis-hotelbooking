package com.desmond.HotelManagement.dao;

import com.desmond.HotelManagement.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void addUser(User user);
    User findByUsername(String username);
}
