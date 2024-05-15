package com.example.example.services;

import com.example.example.models.Course;
import com.example.example.repositories.CourseRepository;
import com.example.example.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(int id, Teacher updatedTeacher) {
        if (teacherRepository.existsById(id)) {
            updatedTeacher.setId(id);
            teacherRepository.save(updatedTeacher);
        }
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
