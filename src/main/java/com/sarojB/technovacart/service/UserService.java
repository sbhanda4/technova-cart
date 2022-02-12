package com.sarojB.technovacart.service;

import com.sarojB.technovacart.model.User;
import com.sarojB.technovacart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) {
        User newUser=new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserbyId(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Optional<User> existingUser, User user) {
        existingUser.get().setFirstName(user.getFirstName());
        existingUser.get().setLastName(user.getLastName());
        existingUser.get().setEmail(user.getEmail());
        return userRepository.save(existingUser.get());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
