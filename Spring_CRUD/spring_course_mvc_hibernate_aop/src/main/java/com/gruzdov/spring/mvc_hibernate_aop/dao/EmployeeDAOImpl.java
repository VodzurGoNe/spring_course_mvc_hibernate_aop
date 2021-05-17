package com.gruzdov.spring.mvc_hibernate_aop.dao;

import com.gruzdov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    SessionFactory factory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = factory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee"
                , Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Session session = factory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Session session = factory.getCurrentSession();

        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
