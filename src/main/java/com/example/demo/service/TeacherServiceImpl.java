package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher getTeacher(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Teacher createTeacher(Teacher student) {
        return teacherRepository.save(student);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
