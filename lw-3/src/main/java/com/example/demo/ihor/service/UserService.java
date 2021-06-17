package com.example.demo.ihor.service;

import com.example.demo.ihor.dao.UserDao;
import com.example.demo.ihor.model.User;
import com.example.demo.ihor.security.entity.AuthorizationUser;
import com.example.demo.ihor.security.entity.UserToken;
import com.example.demo.ihor.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private UserDao userDao;
    private JwtTokenProvider jwtProvider;

    public UserToken login(AuthorizationUser authUser) {
        User user = userDao.findAllByUsername(authUser.getUsername()).orElseThrow();
        //Collection<? extends GrantedAuthority> authorities
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        Authentication auth = new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return new UserToken(jwtProvider.generateAccessToken(auth));

    }
}

