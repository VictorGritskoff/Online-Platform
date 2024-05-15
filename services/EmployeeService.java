package com.example.example.services;

import org.springframework.stereotype.Service;

 @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }


    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

 
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

   
    public void updateEmployee(int id, Employee updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id);
            employeeRepository.save(updatedEmployee);
        }
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
