package com.example.demo.service;

import com.example.demo.entity.StudyTerm;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.StudyTermRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class StudyTermServiceTest {
    @Mock
    private StudyTermRepository studyTermRepository;
    private StudyTermService studyTermService;

    @BeforeEach
    public void init() {
        openMocks(this);
        studyTermService = new StudyTermServiceImpl(studyTermRepository);
    }

    @Test
    public void getStudyTermTest() {
        var teacher1 = new Teacher();
        teacher1.setSubjects(Arrays.asList("math","english"));
        var teacher2 = new Teacher();
        teacher2.setSubjects(Arrays.asList("math","biology"));
        var teacher3 = new Teacher();
        teacher3.setSubjects(List.of("french"));
        var teacher4 = new Teacher();
        teacher4.setSubjects(List.of("geography"));

        var teacherList = Arrays.asList(teacher1, teacher2);

        var studyTerm = new StudyTerm();
        studyTerm.setTeachers(teacherList);
        studyTerm.setId(1);

        when(studyTermRepository.findById(anyLong())).thenReturn(Optional.of(studyTerm));

        Assertions.assertEquals(studyTermService.getStudyTerm(1), studyTerm);
    }
}
