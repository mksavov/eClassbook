package com.example.demo.controller;

import com.example.demo.entity.Parent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.School;
import com.example.demo.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {

   private final SchoolService schoolService;

   public SchoolController(SchoolService schoolService) {
      this.schoolService = schoolService;
   }

   /**
    * Create school.
    *
    * @return The created school.
    */
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<School> createSchool(@RequestBody School school) {
      return new ResponseEntity<>(this.schoolService.createSchool(school), HttpStatus.CREATED);
   }

   /**
    * Get school.
    *
    * @return The school object.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR') || hasRole('ROLE_TEACHER') || hasRole('ROLE_STUDENT')")
   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<School> getSchool(@PathVariable("id") long id) {
      return new ResponseEntity<>(this.schoolService.getSchool(id), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN')")
   @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<School> editSchool(@RequestBody School school) {
      return new ResponseEntity<>(this.schoolService.createSchool(school), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && (hasRole('ROLE_ADMIN'))")
   @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> deleteSchoolById(@RequestParam long id) throws Exception {
      return new ResponseEntity<>(this.schoolService.deleteSchoolById(id), HttpStatus.OK);
   }
}
