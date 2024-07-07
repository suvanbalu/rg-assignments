package net.suvan.employeespring.controller;

import net.suvan.employeespring.exception.ResourceNotFoundException;
import net.suvan.employeespring.model.Employee;
import net.suvan.employeespring.repository.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeJdbcRepository employeeJdbcRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeJdbcRepository.findAll();
    }

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeJdbcRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Employee employee = employeeJdbcRepository.findById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetail){
        Employee updateEmployee = employeeJdbcRepository.findById(id);
        if (updateEmployee == null) {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }

        updateEmployee.setName(employeeDetail.getName());
        updateEmployee.setDepartment(employeeDetail.getDepartment());
        employeeJdbcRepository.update(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        Employee deleteEmployee = employeeJdbcRepository.findById(id);
        if (deleteEmployee == null) {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }
        employeeJdbcRepository.delete(id);
        return ResponseEntity.ok(deleteEmployee);
    }
}
