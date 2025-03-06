package com.salon.booking.salon_booking_app.controller;

import com.salon.booking.salon_booking_app.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User newUser = new User(counter.incrementAndGet(), user.getName(), user.getEmail());
        users.add(newUser);
        return newUser;
    }
}
