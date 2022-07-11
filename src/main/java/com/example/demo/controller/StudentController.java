package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

   private final StudentService studentService;

   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }

   /**
    * Get student.
    *
    * @return The student object.
    */
   @PreAuthorize("isAuthenticated() && (hasRole('ROLE_ADMIN') || hasRole('ROLE_TEACHER') || hasRole('ROLE_DIRECTOR'))")
   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
      return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.OK);
   }

   /**
    * Get all students.
    *
    * @return List of student objects.
    */
   @PreAuthorize("isAuthenticated() && (hasRole('ROLE_ADMIN') || hasRole('ROLE_TEACHER') || hasRole('ROLE_DIRECTOR'))")
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Student>> getAllStudents() {
      return new ResponseEntity<>(this.studentService.getAllStudents(), HttpStatus.OK);
   }

   /**
    * Create Student.
    *
    * @return The created Student.
    */
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Student> createStudent(@RequestBody User user) {
      return new ResponseEntity<>(this.studentService.createStudent(user), HttpStatus.CREATED);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_STUDENT')")
   @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Student> editStudent(@RequestBody Student student) {
      return new ResponseEntity<>(this.studentService.editStudent(student), HttpStatus.OK);
   }

   /**
    * Get all students from school.
    *
    * @return List of student objects.
    */

   @PreAuthorize("isAuthenticated() && (hasRole('ROLE_ADMIN') || hasRole('ROLE_TEACHER') || hasRole('ROLE_DIRECTOR'))")
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Student>> getAllStudentsFromSchool(@RequestBody School school) {
      return new ResponseEntity<>(this.studentService.getAllStudentsFromSchool(school), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && (hasRole('ROLE_ADMIN') || hasRole('ROLE_TEACHER') || hasRole('ROLE_DIRECTOR'))")
   @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> deleteStudentById(@RequestParam long id) throws Exception {
      return new ResponseEntity<>(this.studentService.deleteStudentById(id), HttpStatus.OK);
   }

}
