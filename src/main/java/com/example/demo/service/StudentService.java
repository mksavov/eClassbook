package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudent(long id);
    Student createStudent(Student student);
    List<Student> getAllStudents();
}
