package com.crudexcercises.cruddemo.service;


import com.crudexcercises.cruddemo.dao.EmployeeRepository;
import com.crudexcercises.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements Employeeservice {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository){
        employeeRepository = theemployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theID) {
        Optional<Employee> result = employeeRepository.findById(theID);

        Employee theEmployee =null;

        if(result.isPresent()){
            theEmployee = result.get();
        } else {
            //we didnt find employee
            throw new RuntimeException("Did not found employee id - " + theID);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
