package com.example.demo.ihor.config;

import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@ConfigurationProperties(prefix = "application.jwt")
@Data
@Component
public class SecurityConfig {
    private String header;
    private String secretKey;
    private String tokenPrefix;
    private Integer expiration;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}