package com.desmond.HotelBooking.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class JwtTokenFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        //response.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject json = new JSONObject();

        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            DecodedJWT decodedJWT = JWT.decode(token);
            if(decodedJWT.getExpiresAt().before(new Date())) {
                // Token expired
                json.put("success","false");
                json.put("msg","Unauthorized. Token has expired");
                json.put("code","401");
                response.getWriter().append(json.toString());
                return false;
            }

            if(JwtTokenUtil.verify(token))
                return true;
        }

        // If token is null, or not start with "Bearer" or cannot be verified
        try{
            json.put("success","false");
            json.put("msg","Unauthorized. Invalid JWT token found in request headers");
            json.put("code","401");
            response.getWriter().append(json.toString());
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(401);
            return false;
        }
        return false;
    }
}
