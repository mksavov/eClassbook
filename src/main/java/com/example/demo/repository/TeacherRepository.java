package com.example.demo.repository;

import com.example.demo.entity.School;
import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllBySchool(School school);
    List<Teacher> findAllBySubjects(List<String> Subjects);
}
