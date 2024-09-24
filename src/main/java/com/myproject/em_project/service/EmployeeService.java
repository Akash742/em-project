package com.myproject.em_project.service;

import java.util.*;

import com.myproject.em_project.bean.Employee;

public interface EmployeeService{
    List<Employee> getEmployees();
    Integer addEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
    String updatEmployee(Employee emp, Integer id);
}
