package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {return userRepository.findAll();}

    @Override
    public String deleteById(long id) throws Exception {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Could not delete user: ", e);
        }
        return "User deleted.";
    }
}
