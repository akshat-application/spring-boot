package com.example.demo.packageApi.controller;

import com.example.demo.packageApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class UserController {
    private final List<User> userList = new ArrayList<>();


    public UserController() {
        User user1 = new User(1, "Ida", 32, "ida@mail.com");
        User user2 = new User(2, "Hans", 26, "hans@mail.com");
        User user3 = new User(3, "Lars", 45, "lars@mail.com");
        User user4 = new User(4, "Ben", 32, "ben@mail.com");
        User user5 = new User(5, "Eva", 59, "eva@mail.com");
        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }


    @GetMapping("/user")
    public User getUser(@RequestParam(value = "id", defaultValue = "World") int id) {
        for (User user : userList) {
            if (id == user.getId()) {
                return user;
            }
        }
        return new User(0, "null", 0, "null");
    }

    @PostMapping("/data")
    public Boolean storeData(@RequestBody() User user) {
//        Optional<User> user = userService.getUser(id);
        userList.add(user);
        return true;
    }
}
