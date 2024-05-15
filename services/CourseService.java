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


    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(int id, Course updatedCourse) {
        if (courseRepository.existsById(id)) {
            updatedCourse.setId(id);
            courseRepository.save(updatedCourse);
        }
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
