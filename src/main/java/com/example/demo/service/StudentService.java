package com.example.demo.service;

import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;

import java.util.List;

public interface StudentService {
    Student getStudent(long id);
    Student createStudent(User user);
    List<Student> getAllStudents();
    Student editStudent(Student student);
    List<Student> getAllStudentsFromSchool(School school);
    String deleteStudentById(long id) throws Exception;
}
