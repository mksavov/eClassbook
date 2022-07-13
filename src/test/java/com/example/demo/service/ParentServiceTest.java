package com.example.demo.service;

import com.example.demo.entity.Parent;
import com.example.demo.repository.ParentRepository;
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
public class ParentServiceTest {
    @Mock
    private ParentRepository parentRepository;
    private ParentService parentService;

    @BeforeEach
    public void init() {
        openMocks(this);
        parentService = new ParentServiceImpl(parentRepository);
    }

    @Test
    public void getParentTest() {
        var parent = new Parent();
        parent.setId(1);

        when(parentRepository.findById(anyLong())).thenReturn(Optional.of(parent));

        Assertions.assertEquals(parentService.getParent(1), parent);
    }
}
