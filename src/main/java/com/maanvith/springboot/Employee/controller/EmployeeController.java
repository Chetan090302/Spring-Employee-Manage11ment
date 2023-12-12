package com.maanvith.springboot.Employee.controller;


import com.maanvith.springboot.Employee.entity.Employee;
import com.maanvith.springboot.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService1){
        employeeService=employeeService1;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        //get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        model.addAttribute("employees", theEmployees);
        //add that to the spring model
        return "/employees/list-employees";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){
        Employee e = new Employee();
        model.addAttribute("employee",e);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId")int theId, Model model){
        Employee employee1= employeeService.findById(theId);
        model.addAttribute("employee",employee1);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}

