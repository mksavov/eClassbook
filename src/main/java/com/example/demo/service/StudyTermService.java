package com.example.demo.service;

import com.example.demo.entity.StudyTerm;

public interface StudyTermService {
    StudyTerm getStudyTerm(long id);
    StudyTerm createStudyTerm(StudyTerm studyTerm);
    StudyTerm editStudyTerm(StudyTerm studyTerm);
}
