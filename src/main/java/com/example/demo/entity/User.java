package com.example.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   private String firstName;

   private String lastName;

   private String email;

   private String password;

   @ManyToMany(fetch = FetchType.EAGER)
   private List<Role> roles;

   public User(User user) {
      this.email = user.getEmail();
      this.roles = user.getRoles();
      this.firstName = user.getFirstName();
      this.lastName =user.getLastName();
      this.id = user.getId();
      this.password = user.getPassword();
   }

   public User(String firstName, String lastName, String email, String password, List<Role> roles) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
      this.roles = roles;
   }

   public User() { }
}