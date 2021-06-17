package com.example.demo.ihor.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthorizationUser {
    private String username;
    private String password;
}
