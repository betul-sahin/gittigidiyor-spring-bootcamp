package dev.patika.patika0301.service;

import dev.patika.patika0301.entity.Employee;
import dev.patika.patika0301.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements BaseService<Employee>{

    private final EmployeeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        List<Employee> empList = new ArrayList<>();
        Iterable<Employee> employeeIter = repository.findAll();
        employeeIter.iterator().forEachRemaining(empList::add);
        return empList;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    public int getNumberOfEmployees() {
        return repository.getNumberOfEmployees();
    }

    public List<?> getAgesWithGrouping() {
        return repository.getAgesWithGrouping();
    }

    public List<?> getAgesWithGroupingWithNativeQuery() {
        return repository.getAgesWithGroupingWithNativeQuery();
    }
}
