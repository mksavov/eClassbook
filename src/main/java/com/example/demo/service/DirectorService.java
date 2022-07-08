package com.example.demo.service;

import com.example.demo.entity.Director;
import com.example.demo.entity.User;

public interface DirectorService {
    Director getDirector(long id);
    Director createDirector(User user);
    void deleteDirector(long id);
    Director editDirector(Director director);
}
