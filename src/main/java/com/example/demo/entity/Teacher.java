package com.example.demo.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Teacher extends User {

    @ManyToMany
    private List<Student> students;
}
