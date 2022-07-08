package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(long id);
    Teacher createTeacher(User user);
    List<Teacher> getAllTeachers();
    Teacher editTeacher(Teacher teacher);
}
