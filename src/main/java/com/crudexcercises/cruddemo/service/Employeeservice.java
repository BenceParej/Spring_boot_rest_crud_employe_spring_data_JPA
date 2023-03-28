package com.crudexcercises.cruddemo.service;

import com.crudexcercises.cruddemo.entity.Employee;

import java.util.List;

public interface Employeeservice {

    List<Employee> findAll();

    Employee findById(int theID);

    Employee save(Employee theEmployee);

    void deleteById (int theId);
}
