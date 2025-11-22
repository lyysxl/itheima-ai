package com.itheima.tliaswebmanagement.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;
    public String generateJwt(Map<String, Object> data) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .addClaims(data)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .compact();
    }

    public Map<String, Object> parseJwt(String jwt) {
        System.out.println(JWT_SECRET);
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(jwt).getBody();
    }
}
