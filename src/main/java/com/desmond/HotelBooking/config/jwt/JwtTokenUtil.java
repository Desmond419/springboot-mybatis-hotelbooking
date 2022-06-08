package com.desmond.HotelBooking.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.desmond.HotelBooking.entity.User;

import java.util.Date;

public class JwtTokenUtil {

    private static final long EXPIRE_TIME = 30*60*1000; // Token expired in 30 min
    private static final String TOKEN_SECRET = "secret_key";

    // Generate JWT token to user
    public static String sign(User user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create().withIssuer("auth0").withClaim("email", user.getEmail()).withExpiresAt(expiresAt).sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    // Check whether token valid
    public static boolean verify (String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
