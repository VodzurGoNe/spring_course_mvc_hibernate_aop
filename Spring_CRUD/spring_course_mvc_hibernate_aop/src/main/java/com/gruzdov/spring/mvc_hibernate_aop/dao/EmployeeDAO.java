package com.gruzdov.spring.mvc_hibernate_aop.dao;

import com.gruzdov.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);
}
