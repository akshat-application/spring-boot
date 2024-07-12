package com.example.demo.packageApi.controller;

import com.example.demo.packageApi.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.lang.module.ModuleDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
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
        userList.addAll(Arrays.asList(user1, user2));
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

    @PostMapping(value = "/data")
    public Boolean storeData(@RequestBody String data) {
//        Optional<User> user = userService.getUser(id);
//        userList.add(user);
        Type listType = new TypeToken<User>() {}.getType();
        User user = new Gson().fromJson(data, listType);
        userList.add(user);
        return true;
    }
}
