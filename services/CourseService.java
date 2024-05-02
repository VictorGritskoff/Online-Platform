package com.example.example.services;

import com.example.example.models.Course;
import com.example.example.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesWithTeachers() {
        return courseRepository.findAllWithTeacher();
    }
}
