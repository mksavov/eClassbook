package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher getTeacher(long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher createTeacher(User user) {
        return teacherRepository.save(new Teacher(user, null));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {return this.teacherRepository.save(teacher);}

    @Override
    public String deleteTeacherById(long id) throws Exception {
        try {
            teacherRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Could not delete teacher: ", e);
        }
        return "Teacher deleted.";
    }

    @Override
    public List<Teacher> getAllSubjectTeachers(String subject) {
        return teacherRepository.findAllBySubjectsIn(Collections.singletonList(subject));
    }
}
