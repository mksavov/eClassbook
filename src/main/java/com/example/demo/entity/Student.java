package com.example.demo.entity;

import com.example.demo.enums.Grade;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Student extends User {

    @ElementCollection
    private Map<String, String> grades;

    private Grade grade;

    private Integer missedLectures;

}
