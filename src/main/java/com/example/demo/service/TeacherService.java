package com.example.demo.service;

import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(long id);
    Teacher createTeacher(Teacher student);
    List<Teacher> getAllTeachers();
}
