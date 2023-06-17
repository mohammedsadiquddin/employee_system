package com.example.EmployeeSystemApi.service;
import com.example.EmployeeSystemApi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmpById(Long id);

    Employee updateEmployee(Long id,Employee employee);
}
