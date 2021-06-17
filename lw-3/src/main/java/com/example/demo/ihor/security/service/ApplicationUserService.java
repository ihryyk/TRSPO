package com.example.demo.ihor.security.service;

import com.example.demo.ihor.dao.UserDao;
import com.example.demo.ihor.model.User;
import com.example.demo.ihor.security.entity.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplicationUserService implements UserDetailsService {
    private final UserDao userDao;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user = userDao.findAllByUsername(username).orElseThrow(
                () -> new Exception("User is not found"));
        return ApplicationUser.create(user);
    }
}
