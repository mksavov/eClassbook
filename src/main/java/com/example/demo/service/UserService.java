package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    String deleteById(long id) throws Exception;
}
