package com.desmond.HotelBooking.controller;

import com.desmond.HotelBooking.entity.Hotel;
import com.desmond.HotelBooking.entity.User;
import com.desmond.HotelBooking.service.HotelService;
import com.desmond.HotelBooking.service.UserService;
import com.desmond.HotelBooking.utils.GenUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/name/{name}")
    public ResponseEntity<User> getUserByName (@PathVariable("name") String name) {
        try{
            return new ResponseEntity<User>(userService.findByUsername(name), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") String id) {
        try{
            return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        try{
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") String id) {
        try{
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
