package com.example.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public String getHome() {
        return "teachers";
    }

    @GetMapping("/teachers/{id}")
    public String getTeacherById(@PathVariable int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teacherDetail";
    }

    @GetMapping("/teachers/search")
    public String searchTeachersBySubject(@RequestParam(name = "subject", required = false) String subject, Model model) {
        List<Teacher> teachers = teacherService.searchTeachersBySubject(subject);
        model.addAttribute("teachers", teachers);
        return "teacherList";
    }

    @PostMapping("/teachers/add")
    public String addTeacher(@ModelAttribute Teacher teacher, Model model) {
        teacherService.addTeacher(teacher);
        model.addAttribute("message", "Teacher added successfully");
        return "redirect:/teachers";
    }

    @PutMapping("/teachers/update/{id}")
    public String updateTeacher(@PathVariable int id, @ModelAttribute Teacher teacher, Model model) {
        teacherService.updateTeacher(id, teacher);
        model.addAttribute("message", "Teacher updated successfully");
        return "redirect:/teachers";
    }

    @DeleteMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable int id, Model model) {
        teacherService.deleteTeacher(id);
        model.addAttribute("message", "Teacher deleted successfully");
        return "redirect:/teachers";
    }
}
