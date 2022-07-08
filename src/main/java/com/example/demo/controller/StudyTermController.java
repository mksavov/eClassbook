package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudyTerm;
import com.example.demo.service.StudyTermService;


@RestController
@RequestMapping("/study_term")
public class StudyTermController {

   private final StudyTermService studyTermService;

   public StudyTermController(StudyTermService studyTermService) {
      this.studyTermService = studyTermService;
   }

   /**
    * Create StudyTerm.
    *
    * @return The created StudyTerm.
    */
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudyTerm> createStudyTerm(@RequestBody StudyTerm studyTerm) {
      return new ResponseEntity<>(this.studyTermService.createStudyTerm(studyTerm), HttpStatus.CREATED);
   }

   /**
    * Get StudyTerm.
    *
    * @return The StudyTerm object.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR') || hasRole('ROLE_TEACHER') || hasRole('ROLE_STUDENT')")
   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudyTerm> getStudyTerm(@PathVariable("id") long id) {
      return new ResponseEntity<>(this.studyTermService.getStudyTerm(id), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR')")
   @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudyTerm> editStudyTerm(@RequestBody StudyTerm studyTerm) {
      return new ResponseEntity<>(this.studyTermService.editStudyTerm(studyTerm), HttpStatus.OK);
   }
}
