package com.maanvith.springboot.Employee.service;



import com.maanvith.springboot.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}

