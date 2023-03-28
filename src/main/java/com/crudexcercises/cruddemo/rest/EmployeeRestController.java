package com.crudexcercises.cruddemo.rest;


import com.crudexcercises.cruddemo.entity.Employee;
import com.crudexcercises.cruddemo.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private Employeeservice employeeservice;
    // inject employee dao
    @Autowired
    public EmployeeRestController(Employeeservice theemployeeservice){
        this.employeeservice=theemployeeservice;
    }
    //expose /employees and return the list of employees
    @GetMapping("/employees")
    public List<Employee> findall() {
        return  employeeservice.findAll();
    }

    //add mapping for Get/employees/{employeeid}
    @GetMapping("employees/{employeeId}")
    public Employee getEmployee (@PathVariable int employeeId)
    {
       Employee employee = employeeservice.findById(employeeId);

       if(employee==null){
           throw new RuntimeException("Employee id not found.... " + employeeId);
       }
       return employee;
    }

    //add mapping for POST/employees add new employee
    @PostMapping("/employees")
    public Employee addEmployee (@RequestBody Employee theEmployee){
        //also just in case an ID is passed in JSON.. set it to 0
        //this is to force a save of new item... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeservice.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theemployee)
    {
        Employee dbEmployee = employeeservice.save(theemployee);

        return dbEmployee;
    }

    // add mapping for DELETE / employee/{employeeid} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee (@PathVariable int employeeId){
        Employee theEmployee = employeeservice.findById(employeeId);

        //throw exception if null
        if (theEmployee==null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeservice.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
