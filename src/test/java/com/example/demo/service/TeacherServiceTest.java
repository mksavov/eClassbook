package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {
    @Mock
    private TeacherRepository teacherRepository;

    private TeacherService teacherService;

    @BeforeEach
    public void init() {
        openMocks(this);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    @Test
    public void getAllSubjectTeachersTest() {
        var teacher1 = new Teacher();
        teacher1.setSubjects(Arrays.asList("math","english"));
        var teacher2 = new Teacher();
        teacher2.setSubjects(Arrays.asList("math","biology"));
        var teacher3 = new Teacher();
        teacher3.setSubjects(List.of("french"));
        var teacher4 = new Teacher();
        teacher4.setSubjects(List.of("geography"));

        var teacherList = Arrays.asList(teacher1, teacher2);
        when(teacherRepository.findAllBySubjectsIn(anyList())).thenReturn(teacherList);

        Assertions.assertEquals(teacherService.getAllSubjectTeachers("math"), teacherList);

    }


}
