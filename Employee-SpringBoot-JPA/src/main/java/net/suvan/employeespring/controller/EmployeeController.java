package net.suvan.employeespring.controller;

import net.suvan.employeespring.exception.ResourceNotFoundException;
import net.suvan.employeespring.model.Employee;
import net.suvan.employeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : "+id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetail){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : "+id));

        updateEmployee.setName(employeeDetail.getName());
        updateEmployee.setDepartment(employeeDetail.getDepartment());
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        Employee deleteEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Employee not exist with id : "+id)));
        employeeRepository.delete(deleteEmployee);
        return ResponseEntity.ok(deleteEmployee);
    }
}
