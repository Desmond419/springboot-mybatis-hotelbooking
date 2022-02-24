package com.desmond.HotelManagement.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.desmond.HotelManagement.entity.User;

import java.util.Date;

public class JwtTokenUtil {

    private static final long EXPIRE_TIME = 15*60*1000; // Token expired in 15 min
    private static final String TOKEN_SECRET = "secret_key";

    public static String sign(User user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create().withIssuer("auth0").withClaim("username", user.getUsername()).withExpiresAt(expiresAt).sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public static boolean verify (String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("Successful");
            System.out.println("issuer: " + jwt.getIssuer());
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("Token expired in：      " + jwt.getExpiresAt());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
