package com.example.demo.controller;

import java.util.Collections;

import com.example.demo.entity.*;
import com.example.demo.service.AuthService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {

   private final AuthService authService;

   private final UserService userService;

   public AuthenticationController(AuthService authService, UserService userService) {
      this.authService = authService;
      this.userService = userService;
   }

   /**
    * Register client.
    */
   @PostMapping("/student/register")
   public ResponseEntity<User> registerStudent(@RequestBody User user) {
      authService.registerUser(user, Collections.singleton("ROLE_STUDENT"));
      return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
   }

   /**
    * Register client.
    */
   @PostMapping("/director/register")
   public ResponseEntity<User> registerDirector(@RequestBody User user) {
      this.authService.registerUser(user, Collections.singleton("ROLE_DIRECTOR"));

      return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
   }

   /**
    * Register client.
    */
   @PostMapping("/teacher/register")
   public ResponseEntity<User> registerTeacher(@RequestBody User user) {
      this.authService.registerUser(user, Collections.singleton("ROLE_TEACHER"));

      return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
   }

   /**
    * Register employee.
    */
   @PostMapping("/parent/register")
   public ResponseEntity<User> registerParent(@RequestBody User user) {
      this.authService.registerUser(user, Collections.singleton("ROLE_PARENT"));

      return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
   }

   /**
    * Register admin.
    */
   @PostMapping("/admin/register")
   public ResponseEntity<Void> registerAdmin(@RequestBody User user) {
      this.authService.createAdmin(user);
      return new ResponseEntity<>(HttpStatus.OK);
   }


   /**
    * Get the profile of the current user.
    */
   @PreAuthorize("isAuthenticated()")
   @GetMapping(path ="/profile", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<CurrentUser> showProfile() {
      return new ResponseEntity<>(this.authService.getCurrentUser(), HttpStatus.OK);
   }
}