package com.gruzdov.spring.mvc_hibernate_aop.dao;

import com.gruzdov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    SessionFactory factory;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = factory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee"
                , Employee.class).getResultList();

        return allEmployees;
    }
}
