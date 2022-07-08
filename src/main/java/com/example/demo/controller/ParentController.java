package com.example.demo.controller;

import com.example.demo.entity.Director;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Parent;
import com.example.demo.entity.User;
import com.example.demo.service.ParentService;

@RestController
@RequestMapping("/parent")
public class ParentController {

   private final ParentService parentService;

   public ParentController(ParentService parentService) {
      this.parentService = parentService;
   }

   /**
    * Create parent.
    *
    * @return The parent object.
    */
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Parent> createParent(@RequestBody User user) {
      return new ResponseEntity<>(this.parentService.createParent(user), HttpStatus.CREATED);
   }

   /**
    * Get parent.
    *
    * @return The parent object.
    */
   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_DIRECTOR') || hasRole('ROLE_TEACHER') || hasRole('ROLE_STUDENT')")
   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Parent> getParent(@PathVariable("id") long id) {
      return new ResponseEntity<>(this.parentService.getParent(id), HttpStatus.OK);
   }

   @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN') || hasRole('ROLE_PARENT')")
   @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Parent> editParent(@RequestBody Parent parent) {
      return new ResponseEntity<>(this.parentService.editParent(parent), HttpStatus.OK);
   }
}
