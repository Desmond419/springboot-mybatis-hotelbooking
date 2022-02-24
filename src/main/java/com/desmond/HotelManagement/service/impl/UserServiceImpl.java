package com.desmond.HotelManagement.service.impl;

import com.desmond.HotelManagement.dao.UserDao;
import com.desmond.HotelManagement.entity.User;
import com.desmond.HotelManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String name){
        return userDao.findByUsername(name);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
