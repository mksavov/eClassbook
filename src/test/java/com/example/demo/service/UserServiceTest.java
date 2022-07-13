package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
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
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @BeforeEach
    public void init() {
        openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }


    @Test
    public void getAllUsersTest() {
        var user1 = new User();
        user1.setEmail("test");
        user1.setFirstName("ivan");
        user1.setLastName("ivanov");
        user1.setPassword("123");

        var user2 = new User();
        user2.setEmail("test1");
        user2.setFirstName("ivan1");
        user2.setLastName("ivanov1");
        user2.setPassword("abv");

        var user3 = new User();
        user3.setEmail("test2");
        user3.setFirstName("ivan2");
        user3.setLastName("ivanov2");
        user3.setPassword("456");

        var userList = Arrays.asList(user1, user2, user3);

        when(userRepository.findAll()).thenReturn(userList);

        Assertions.assertEquals(userList, userService.getAllUsers());

    }

    @Test
    public void saveUserTest() {
        var user1 = new User();
        user1.setEmail("test");
        user1.setFirstName("ivan");
        user1.setLastName("ivanov");
        user1.setPassword("123");

        when(userRepository.save(any())).thenReturn(user1);

        Assertions.assertEquals(user1, userService.createUser(user1));
    }
}
