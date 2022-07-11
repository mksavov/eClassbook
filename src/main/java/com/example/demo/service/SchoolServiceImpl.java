package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School getSchool(long id) {
        return this.schoolRepository.findById(id).get();
    }

    @Override
    public School createSchool(School school) {
        return this.schoolRepository.save(school);
    }

    @Override
    public String deleteSchoolById(long id) throws Exception {
        try {
            schoolRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Could not delete school: ", e);
        }
        return "School deleted.";
    }

}
