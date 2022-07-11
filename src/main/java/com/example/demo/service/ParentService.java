package com.example.demo.service;

import com.example.demo.entity.Parent;
import com.example.demo.entity.User;

public interface ParentService {
    Parent getParent(long id);
    Parent createParent(User user);
    Parent editParent(Parent parent);
    String deleteParentById(long id) throws Exception;
}
