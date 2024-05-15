package com.example.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployeesHome() {
        return "employees";
    }

    @GetMapping("/employees/{id}")
    public String getEmployeeById(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

    @GetMapping("/employees/search")
    public String searchEmployees(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Employee> employees = employeeService.searchEmployeesByName(name);
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.addEmployee(employee);
        model.addAttribute("message", "Employee added successfully");
        return "employees";
    }

    @PutMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute Employee employee, Model model) {
        employeeService.updateEmployee(id, employee);
        model.addAttribute("message", "Employee updated successfully");
        return "employees";
    }

    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        employeeService.deleteEmployee(id);
        model.addAttribute("message", "Employee deleted successfully");
        return "employees";
    }
}

