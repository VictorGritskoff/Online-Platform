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

}
