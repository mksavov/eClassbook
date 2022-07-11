package com.example.demo.controller;

import com.example.demo.entity.StudyTerm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Director;
import com.example.demo.entity.User;
import com.example.demo.service.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {

   private final DirectorService directorService;

   public DirectorController(DirectorService directorService) {
      this.directorService = directorService;
   }

   /**
    * Create director.
    *
    * @return The director object.
    */
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Director> createDirector(@RequestBody User user) {
      return new ResponseEntity<>(this.directorService.createDirector(user), HttpStatus.CREATED);
   }

   /**
    * Get director.
    *
    * @return The director object.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR') || hasRole('ROLE_TEACHER') || hasRole('ROLE_STUDENT')")
   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Director> getDirector(@PathVariable("id") long id) {
      return new ResponseEntity<>(this.directorService.getDirector(id), HttpStatus.OK);
   }

   /**
    * Delete director.
    *
    * @return message.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN')")
   @DeleteMapping(path = "/{id}")
   public ResponseEntity<String> deleteDirector(@PathVariable("id") long id) {
      return new ResponseEntity<>("Director deleted", HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR')")
   @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Director> editDirector(@RequestBody Director director) {
      return new ResponseEntity<>(this.directorService.editDirector(director), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && (hasRole('ROLE_ADMIN')) || hasRole('ROLE_DIRECTOR')")
   @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> deleteDirectorById(@RequestParam long id) throws Exception {
      return new ResponseEntity<>(this.directorService.deleteDirectorById(id), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR')")
   @PutMapping(path = "/removeTeacherFromStudyTerm", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> removeTeacherFromStudyTerm(@RequestParam long teacherId, @RequestParam long studyTermId) {
      return new ResponseEntity<>(this.directorService.removeTeacherFromStudyTerm(teacherId, studyTermId), HttpStatus.OK);
   }
}
