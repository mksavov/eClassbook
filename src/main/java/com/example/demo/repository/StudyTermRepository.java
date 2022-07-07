package com.example.demo.repository;

import com.example.demo.entity.StudyTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyTermRepository extends JpaRepository<StudyTerm, Long> {
}
