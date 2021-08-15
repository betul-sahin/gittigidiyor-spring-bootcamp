package dev.patika.patika0202.service;

import dev.patika.patika0202.dao.EmployeeDAO;
import dev.patika.patika0202.dao.EmployeeDAOJPAImpl;
import dev.patika.patika0202.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements BaseService<Employee>{

    private EmployeeDAO employeeDAOJPA;

    public EmployeeService(@Qualifier("employeeDAOHibernateImpl") EmployeeDAO employeeDAOJPA) {
        this.employeeDAOJPA = employeeDAOJPA;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAOJPA.findAll();
    }

    @Override
    public Employee findById(int id) {
        return (Employee) employeeDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return (Employee) employeeDAOJPA.save(employee);
    }

    @Override
    public void deleteById(int id) {

    }
}
