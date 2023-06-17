package com.example.EmployeeSystemApi.controller;

import com.example.EmployeeSystemApi.entity.Employee;
import com.example.EmployeeSystemApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://fluffy-stardust-d7f060.netlify.app")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getEmp(){
        List<Employee> employeeList =  employeeService.getEmployees();
        return employeeList;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.createEmployee(employee);
        return employee1;
    }

    @DeleteMapping("/employees/{id}")
    public Map delEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted= employeeService.deleteEmployee(id);
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return response;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmpById(@PathVariable Long id){
        Employee employee = employeeService.getEmpById(id);
        return employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(id,employee);
        return employee1;
    }
}
