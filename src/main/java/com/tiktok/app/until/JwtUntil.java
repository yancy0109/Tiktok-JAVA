package com.tiktok.app.until;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

public class JwtUntil {
    public static String generateToken(Integer userId) {
        Date now = new Date(System.currentTimeMillis());
        Calendar endtime = Calendar.getInstance();
        endtime.setTime(now);
        endtime.add(Calendar.HOUR_OF_DAY, 1);
        Date end = endtime.getTime();

        Map<String, Object> claims = new HashMap();
        claims.put("userid", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setAudience("admin")
                .setExpiration(end)
                .signWith(SignatureAlgorithm.HS256, "tiktok");

        return jwtBuilder.compact();
    }
    public static Integer parseToken(String token){
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey("tiktok")
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
           return null;
        }
        return (Integer) claims.get("userid");
    }
}

