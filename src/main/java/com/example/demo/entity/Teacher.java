package com.example.demo.entity;

import java.util.List;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Student> students;

    @OneToOne
    private School school;

    @ElementCollection
    private List<String> subjects;

    public Teacher(User user, List<Student> students) {
        this.user = user;
        this.students = students;
    }

    public Teacher() {

    }
}
