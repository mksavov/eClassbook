package com.example.demo.service;

import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import com.example.demo.enums.Grade;
import com.example.demo.repository.StudentRepostiory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepostiory studentRepostiory;
    private StudentService studentService;

    @BeforeEach
    public void init() {
        openMocks(this);
        studentService = new StudentServiceImpl(studentRepostiory);
    }

    @Test
    public void getAllStudentsFromSchoolTest() {
        var student1 = new Student();
        var student2 = new Student();
        var student3 = new Student();
        var student4 = new Student();

        School school = new School();

        student1.setSchool(school);
        student2.setSchool(school);
        student3.setSchool(school);
        student4.setSchool(school);

        var studentList = Arrays.asList(student1, student2, student3, student4);

        when(studentRepostiory.findAllBySchool(any())).thenReturn(studentList);

        Assertions.assertEquals(studentService.getAllStudentsFromSchool(school), studentList);
    }
}
