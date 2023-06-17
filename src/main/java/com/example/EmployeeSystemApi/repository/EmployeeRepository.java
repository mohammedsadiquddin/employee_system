package com.example.EmployeeSystemApi.repository;

import com.example.EmployeeSystemApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
