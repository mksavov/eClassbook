package com.example.demo.service;

import com.example.demo.entity.Parent;
import com.example.demo.entity.School;

public interface SchoolService {
    School getSchool(long id);
    School createSchool(School school);
    String deleteSchoolById(long id) throws Exception;
}
