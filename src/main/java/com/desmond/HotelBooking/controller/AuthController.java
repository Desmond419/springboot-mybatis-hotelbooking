package com.desmond.HotelBooking.controller;

import com.desmond.HotelBooking.config.jwt.JwtTokenUtil;
import com.desmond.HotelBooking.entity.User;
import com.desmond.HotelBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value="/login")
    public Map<String,Object> login(@RequestBody User user) {
        Map<String,Object> map = new HashMap<>();
        try{
            User foundUser = userService.findByUserEmail(user.getEmail());

            if(foundUser != null){
                /**
                 * Hardcode login for development phase
                 * Admin Credential
                 * email: admin@email.com
                 * password: admin
                 */
                if(passwordEncoder.matches(user.getPassword(), foundUser.getPassword()) ||
                        user.getEmail().equals("admin@email.com") && user.getPassword().equals("admin")){
                    String token = JwtTokenUtil.sign(user); // Generate JWT token if user valid
                    if(token != null){
                        map.put("code", "200");
                        map.put("message", "Authorized");
                        map.put("userId", foundUser.getId());
                        map.put("token", token);
                        return map;
                    }
                } else {
                    map.put("code", "401");
                    map.put("message", "Unauthorized");
                    return map;
                }
            }
            map.put("code", "404");
            map.put("message", "User Not Found");
            return map;
        } catch (Exception e){
            map.put("code", "500");
            map.put("message", "Internal Server Error");
            return map;
        }
    }
}
