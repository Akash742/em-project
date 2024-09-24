package com.myproject.em_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.em_project.bean.Employee;
import com.myproject.em_project.service.EmployeeService;

@RestController
public class EmpController {

    @Autowired
    EmployeeService empService;

    @GetMapping("employee")
    public List<Employee> getEmployee() {

        return empService.getEmployees();
    }

    @PostMapping("employee-form")
    public String createEmployee(@RequestBody Employee emp) {
        Integer id = empService.addEmployee(emp);
        System.out.println("Id: " + id);
        return "Employee created with id: " + id;
    }

    @DeleteMapping("employee-delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        if (empService.deleteEmployee(id)) {
            return "Successfully Deleted";
        }
        return "Not Found";
    }

    @PutMapping("employee-update/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
        return empService.updatEmployee(emp, id);
    }
}
