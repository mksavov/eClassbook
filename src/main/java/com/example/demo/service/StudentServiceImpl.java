package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
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
        return studentRepostiory.findById(id).get();
    }

    @Override
    public Student createStudent(User user) {
        return studentRepostiory.save(new Student(user, null, null, 0));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepostiory.findAll();
    }

    @Override
    public Student editStudent(Student student) {return this.studentRepostiory.save(student);}
}
