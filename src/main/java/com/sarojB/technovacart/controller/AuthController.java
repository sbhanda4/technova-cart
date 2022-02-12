package com.sarojB.technovacart.controller;


import com.sarojB.technovacart.model.User;
import com.sarojB.technovacart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/auth")
public class AuthController {
    @GetMapping("/hello")
    public String getHello()
    {
        return "Hello World";
    }
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public User createUser (@RequestBody User user){
        return userService.createUser(user);

    }
}

