package com.example.repository;

import com.example.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
