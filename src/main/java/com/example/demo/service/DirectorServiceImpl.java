package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Director;
import com.example.demo.entity.User;
import com.example.demo.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    private final UserRepository userRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository, UserRepository userRepository) {
        this.directorRepository = directorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Director getDirector(long id) {
        return this.directorRepository.findById(id).get();
    }

    @Override
    public Director createDirector(User user) {
        userRepository.save(user);
        return this.directorRepository.save(new Director(user, null));
    }

    @Override
    public void deleteDirector(long id) {
        this.directorRepository.deleteById(id);
    }

    @Override
    public Director editDirector(Director director) {
        return this.directorRepository.save(director);
    }

}
