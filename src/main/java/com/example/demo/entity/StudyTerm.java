package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class StudyTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    private List<String> subjects;

    @OneToMany
    private List<Teacher> teachers;
}
