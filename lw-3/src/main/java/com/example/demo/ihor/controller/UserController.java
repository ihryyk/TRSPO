package com.example.demo.ihor.controller;

import com.example.demo.ihor.security.entity.AuthorizationUser;
import com.example.demo.ihor.security.entity.UserToken;
import com.example.demo.ihor.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public UserToken login(@RequestBody AuthorizationUser user) {
        return userService.login(user);
    }
}
