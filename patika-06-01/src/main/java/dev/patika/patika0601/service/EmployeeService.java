package dev.patika.patika0601.service;

import dev.patika.patika0601.exceptions.EmployeeAlreadyExistsException;
import dev.patika.patika0601.exceptions.EmployeeNotFoundException;
import dev.patika.patika0601.model.Employee;
import dev.patika.patika0601.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public void addEmployee(Employee employee) {
        if(this.repository.existsAllByEmail(employee.getEmail()))
            throw new EmployeeAlreadyExistsException("Employee with E-mail: "+ employee.getEmail() + " is already exists!");
        repository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        if(!this.repository.existsAllById(employeeId))
            throw new EmployeeNotFoundException("Employee with ID: " + employeeId + " could not foud!");
        repository.deleteById(employeeId);

    }
}
