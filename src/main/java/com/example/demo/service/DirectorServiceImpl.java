package com.example.demo.service;

import com.example.demo.entity.StudyTerm;
import com.example.demo.repository.StudyTermRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Director;
import com.example.demo.entity.User;
import com.example.demo.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    private final UserRepository userRepository;

    private final StudyTermRepository studyTermRepository;

    private final TeacherRepository teacherRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository,
                               UserRepository userRepository,
                               StudyTermRepository studyTermRepository,
                               TeacherRepository teacherRepository) {
        this.directorRepository = directorRepository;
        this.userRepository = userRepository;
        this.studyTermRepository = studyTermRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Director getDirector(long id) {
        return this.directorRepository.findById(id).get();
    }

    @Override
    public Director createDirector(User user) {
        userRepository.save(user);
        return this.directorRepository.save(new Director(user, null));
    }

    @Override
    public void deleteDirector(long id) {
        this.directorRepository.deleteById(id);
    }

    @Override
    public Director editDirector(Director director) {
        return this.directorRepository.save(director);
    }

    @Override
    public String deleteDirectorById(long id) throws Exception {
        try {
            directorRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Could not delete director: ", e);
        }
        return "Director deleted.";
    }

    @Override
    public String removeTeacherFromStudyTerm(long teacherId, long studyTermId) {
        teacherRepository.findById(teacherId)
                .ifPresent(teacherToBeRemoved -> studyTermRepository.findById(studyTermId)
                        .ifPresent(studyTermSource -> studyTermSource.getTeachers()
                                .removeIf(teacher -> teacher.equals(teacherToBeRemoved))));

        return "Teacher removed from study term.";
    }
}
