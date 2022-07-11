package com.example.demo.entity;

import com.example.demo.enums.Grade;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.Map;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User user;

    @ElementCollection
    private Map<String, String> grades;

    private Grade grade;

    private Integer missedLectures;

    @OneToOne
    private School school;

    public Student(User user, Map<String, String> grades, Grade grade, Integer missedLectures) {
        this.user = user;
        this.grades = grades;
        this.grade = grade;
        this.missedLectures = missedLectures;
    }

    public Student() {

    }
}
