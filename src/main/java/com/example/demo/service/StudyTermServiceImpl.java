package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudyTerm;
import com.example.demo.repository.StudyTermRepository;

@Service
public class StudyTermServiceImpl implements StudyTermService {

    private final StudyTermRepository studyTermRepository;

    public StudyTermServiceImpl(StudyTermRepository studyTermRepository) {
        this.studyTermRepository = studyTermRepository;
    }

    @Override
    public StudyTerm getStudyTerm(long id) {
        return this.studyTermRepository.findById(id).get();
    }

    @Override
    public StudyTerm createStudyTerm(StudyTerm studyTerm) {
        return this.studyTermRepository.save(studyTerm);
    }

    @Override
    public StudyTerm editStudyTerm(StudyTerm studyTerm) {return this.studyTermRepository.save(studyTerm);}

    @Override
    public String deleteStudyTermById(long id) throws Exception {
        try {
            studyTermRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Could not delete study term: ", e);
        }
        return "Study term deleted.";
    }
}
