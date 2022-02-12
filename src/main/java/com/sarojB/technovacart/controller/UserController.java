package com.sarojB.technovacart.controller;

import com.sarojB.technovacart.model.User;
import com.sarojB.technovacart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object getAllUsers(@RequestParam(name="email",required = false)String email) {
        if(email!=null){
            return userService.getUserByEmail(email);
        }
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserbyId(id);
    }

    //Update mapping
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        Optional<User> existingUser = userService.getUserbyId(id);
        if (existingUser.isPresent()) {
            return userService.updateUser( existingUser,user);
        }
        return user;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User with id "+id+" deleted sucessfully";
    }
}