package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepostiory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepostiory studentRepostiory;

    public StudentServiceImpl(StudentRepostiory studentRepostiory) {
        this.studentRepostiory = studentRepostiory;
    }

    @Override
    public Student getStudent(long id) {
        return studentRepostiory.getById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepostiory.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepostiory.findAll();
    }
}
