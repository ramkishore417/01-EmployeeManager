package com.practice.services;

import com.practice.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practice.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService
{
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepo.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Employee employee, int id) {
        Employee updateEmployee=employeeRepo.findById(id).get();
        updateEmployee.setId(employee.getId());
        updateEmployee.setName(employee.getName());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setJobTitle(employee.getJobTitle());
        updateEmployee.setPhone(employee.getPhone());
        updateEmployee.setImageUrl(employee.getImageUrl());
        employeeRepo.save(updateEmployee);

        return employeeRepo.save(employee);
    }

    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }

//	    public Employee findEmployeeById(int id) throws UserNotFoundException {
//	        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
//	    }

}
