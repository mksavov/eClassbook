package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Parent;
import com.example.demo.entity.User;
import com.example.demo.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent getParent(long id) {
        return this.parentRepository.findById(id).get();
    }

    @Override
    public Parent createParent(User user) {
        return this.parentRepository.save(new Parent(user, null));
    }

    @Override
    public Parent editParent(Parent parent) {
        return this.parentRepository.save(parent);
    }

    @Override
    public String deleteParentById(long id) throws Exception {
        try {
        parentRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Could not delete parent: ", e);
    }
        return "Parent deleted.";
    }
}
