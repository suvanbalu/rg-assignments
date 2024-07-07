package net.suvan.employeespring.repository;

import net.suvan.employeespring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //we add Integer as second parameter because id is of Integer

}
