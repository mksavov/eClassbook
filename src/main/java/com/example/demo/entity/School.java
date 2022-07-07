package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class School {

    @Id
    private long id;

    private String name;

    private String address;

    @OneToMany
    private List<Student> students;

    @OneToMany
    private List<Teacher> teachers;

    @OneToOne
    private Director director;

    @OneToOne
    private StudyTerm studyTerm;
}
