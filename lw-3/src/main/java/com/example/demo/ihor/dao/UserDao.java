package com.example.demo.ihor.dao;

import com.example.demo.ihor.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "misha", "$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u", "ROLE_ADMIN"));
        users.add(new User(2, "ihor", "$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u", "ROLE_USER"));
    }

    public Optional<User> findAllByUsername(String username) {
        return users.stream().filter(x -> x.getName().equals(username)).findFirst();
    }
}
