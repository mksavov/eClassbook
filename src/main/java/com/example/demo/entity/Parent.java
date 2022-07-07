package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Parent extends User {
    @OneToMany
    List<Student> kids;
}
