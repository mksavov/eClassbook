package com.example.demo.service;

import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class SchoolServiceTest {
    @Mock
    private SchoolRepository schoolRepository;

    private SchoolService schoolService;

    @BeforeEach
    public void init() {
        openMocks(this);
        schoolService = new SchoolServiceImpl(schoolRepository);
    }

    @Test
    public void getSchoolTest() {
        var school = new School();
        school.setId(2);

        when(schoolRepository.findById(anyLong())).thenReturn(Optional.of(school));

        Assertions.assertEquals(schoolService.getSchool(2), school);
    }
}
