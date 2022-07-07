package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(nullable = false, unique = true)
   private String name;

   public Role(String name) {
      this.name = name;
   }
}