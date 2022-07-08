package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

   private final TeacherService teacherService;

   public TeacherController(TeacherService teacherService) {
      this.teacherService = teacherService;
   }

   /**
    * Create Teacher.
    *
    * @return The created Teacher.
    */
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Teacher> createTeacher(@RequestBody User user) {
      return new ResponseEntity<>(teacherService.createTeacher(user), HttpStatus.CREATED);
   }

   /**
    * Get Teacher.
    *
    * @return The Teacher object.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR')")
   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Teacher> getTeacher(@PathVariable("id") long id) {
      return new ResponseEntity<>(teacherService.getTeacher(id), HttpStatus.OK);
   }

   /**
    * Get all Teachers.
    *
    * @return List of Teacher objects.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR')")
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Teacher>> getAllTeachers() {
      return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_TEACHER')")
   @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Teacher> editTeacher(@RequestBody Teacher teacher) {
      return new ResponseEntity<>(this.teacherService.editTeacher(teacher), HttpStatus.OK);
   }
}
