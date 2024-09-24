package com.myproject.em_project.service;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.em_project.bean.Employee;
import com.myproject.em_project.dao.EmployeeDAO;
import com.myproject.em_project.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getEmployees() {
        // TODO Auto-generated method stub
        List<EmployeeEntity> entityList = employeeDAO.findAll();
        List<Employee> empList = new ArrayList<>();

        for(EmployeeEntity entity : entityList){
            Employee emp = new Employee();
            BeanUtils.copyProperties(entity, emp);
            empList.add(emp);
        }

        return empList;
    }

    @Override
    public Integer addEmployee(Employee employee) {
        // TODO Auto-generated method stub
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        return employeeDAO.save(entity).getEmp_id();
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        // TODO Auto-generated method stub
        if(employeeDAO.findById(id) != null)
        {
           employeeDAO.deleteById(id);
           return true;
        }
        return false;
    }

    @Override
    public String updatEmployee(Employee emp, Integer id) {
        // TODO Auto-generated method stub
        if(employeeDAO.existsById(id))
        {
           EmployeeEntity entity = employeeDAO.findById(id).get();
           entity.setEmp_name(emp.getEmp_name());
           entity.setDept(emp.getDept());
           entity.setRole(emp.getRole());

           employeeDAO.save(entity);
        }
        return "Updated Employee";
    }
    
}
