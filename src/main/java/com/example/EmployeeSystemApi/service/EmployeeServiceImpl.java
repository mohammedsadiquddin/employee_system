package com.example.EmployeeSystemApi.service;

import com.example.EmployeeSystemApi.entity.Employee;
import com.example.EmployeeSystemApi.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    @Transactional
    public boolean deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
        }

    @Override
    public Employee getEmpById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id,Employee employee){
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmailId(employee.getEmailId());
        return employee;
    }
}
