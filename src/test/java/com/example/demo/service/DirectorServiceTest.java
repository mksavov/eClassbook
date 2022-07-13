package com.example.demo.service;

import com.example.demo.entity.StudyTerm;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.DirectorRepository;
import com.example.demo.repository.StudyTermRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class DirectorServiceTest {
    @Mock
    private DirectorRepository directorRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private StudyTermRepository studyTermRepository;
    @Mock
    private TeacherRepository teacherRepository;

    private DirectorService directorService;

    @BeforeEach
    public void init() {
        openMocks(this);
        directorService = new DirectorServiceImpl(directorRepository, userRepository, studyTermRepository, teacherRepository);
    }

    @Test
    public void removeTeacherFromStudyTermTest() {
        var teacher1 = new Teacher();
        teacher1.setSubjects(Arrays.asList("math","english"));
        var teacher2 = new Teacher();
        teacher2.setSubjects(Arrays.asList("math","biology"));
        var teacher3 = new Teacher();
        teacher3.setSubjects(List.of("french"));
        teacher3.setId(3);
        var teacher4 = new Teacher();
        teacher4.setSubjects(List.of("geography"));

        var teacherList = new LinkedList<>(Arrays.asList(teacher1, teacher2, teacher3, teacher4));

        var studyTerm = new StudyTerm();
        studyTerm.setTeachers(teacherList);
        studyTerm.setId(1);

        when(studyTermRepository.findById(anyLong())).thenReturn(Optional.of(studyTerm));
        when(teacherRepository.findById(anyLong())).thenReturn(Optional.of(teacher3));

        directorService.removeTeacherFromStudyTerm(teacher3.getId(), studyTerm.getId());

        Assertions.assertEquals(3, studyTerm.getTeachers().size());

    }
}
