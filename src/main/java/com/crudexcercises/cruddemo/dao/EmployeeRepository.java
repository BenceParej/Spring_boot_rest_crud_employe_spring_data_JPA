package com.crudexcercises.cruddemo.dao;

import com.crudexcercises.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //no code needed to write any code
}
