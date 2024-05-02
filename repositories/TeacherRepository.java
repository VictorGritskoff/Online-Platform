package com.example.example.repositories;

import com.example.example.models.Course;
import com.example.example.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
