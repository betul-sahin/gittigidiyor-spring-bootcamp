package dev.patika.patika0601.repository;

import dev.patika.patika0601.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsAllById(long id);
    boolean existsAllByEmail(String email);
}
