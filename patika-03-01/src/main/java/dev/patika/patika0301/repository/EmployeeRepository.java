package dev.patika.patika0301.repository;


import dev.patika.patika0301.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query("select count(e) from Employee e")
    int getNumberOfEmployees();

    @Query("select e.age, count(e.age) from Employee e GROUP BY e.age")
    List<?> getAgesWithGrouping();

    @Query(nativeQuery = true, value = "select age AS age, count(age) AS count from employee e GROUP BY age")
    List<EmployeeAgeStatistics> getAgesWithGroupingWithNativeQuery();
}
