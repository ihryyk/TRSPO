package com.example.demo.ihor.security.jwt;
;
import com.example.demo.ihor.config.SecurityConfig;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class JwtTokenProvider {
    private final SecurityConfig securityConfig;

    public String generateAccessToken(Authentication authResult) {
        System.out.println("info " + authResult.getAuthorities());
        return securityConfig.getTokenPrefix() + Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(Date.valueOf(LocalDate.now().plusWeeks(securityConfig.getExpiration())))
                .signWith(securityConfig.getSecretKey())
                .compact();
    }
}
