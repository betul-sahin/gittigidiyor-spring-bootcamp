package dev.patika.patika0601.service;

import dev.patika.patika0601.exception.EmployeeIsAlreadyExistException;
import dev.patika.patika0601.model.Employee;
import dev.patika.patika0601.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void addEmployee(Employee employee) {
        // TO-DO check if employee exists???
        if (repository.findByEmail(employee.getEmail()) == null) {
            throw new EmployeeIsAlreadyExistException("There is an employee with the same email : "+ employee.getEmail()+ " on the db");
        }

        repository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        // TO-DO check if employee exists with given ID???
        Optional<Employee> employee = repository.findById(employeeId);
        if (!employee.isPresent()) {
            throw new EmployeeIsAlreadyExistException("Employee with id: " + employeeId + " is already exist in db");
        }

        repository.deleteById(employeeId);
    }
}
