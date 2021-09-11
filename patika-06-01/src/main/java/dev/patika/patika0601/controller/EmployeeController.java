package dev.patika.patika0601.controller;

import dev.patika.patika0601.model.Employee;
import dev.patika.patika0601.model.Gender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getAllEmployees(){
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Koray Guney", "k@g.com", Gender.MALE),
                new Employee(2L, "Ayse Kaya", "a@k.com", Gender.FEMALE),
                new Employee(3L, "Hasan Huseyin", "h@h.com", Gender.MALE)
        );
        return employees;
    }

}
