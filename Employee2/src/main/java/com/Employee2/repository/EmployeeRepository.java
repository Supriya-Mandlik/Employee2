package com.Employee2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
