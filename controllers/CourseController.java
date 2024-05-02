package com.example.example.controllers;

import com.example.example.dto.CourseDetailsDTO;
import com.example.example.models.Course;
import com.example.example.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String getCourses(Model model) {

        // Получаем список курсов с преподавателями
        List<Course> courseList = courseService.getCoursesWithTeachers();

        // Преобразуем список курсов в список DTO
        List<CourseDetailsDTO> coursesWithTeachers = courseList.stream()
                .map(course -> new CourseDetailsDTO(
                        course.getCourseId(),
                        course.getName(),
                        course.getPrice(),
                        course.getTeacher().getFirstName(),
                        course.getTeacher().getLastName(),
                        course.getTeacher().getSurname()))
                .collect(Collectors.toList());

        // Передаем список курсов с преподавателями в модель
        model.addAttribute("coursesWithTeachers", coursesWithTeachers);

        // Возвращаем имя представления
        return "course";
    }
}
