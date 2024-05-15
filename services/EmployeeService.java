package com.example.example.services;

import org.springframework.stereotype.Service;

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
