package net.suvan.employeespring.repository;

import net.suvan.employeespring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Employee> rowMapper = (rs, rowNum) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setDepartment(rs.getString("department"));
        return employee;
    };

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", rowMapper);
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id = ?", new Object[]{id}, rowMapper);
    }

    public Employee save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees (name, department) VALUES (?, ?)",
                employee.getName(), employee.getDepartment());
        return employee; // Simplified version: ideally, fetch back the generated ID
    }

    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE employees SET name = ?, department = ? WHERE id = ?",
                employee.getName(), employee.getDepartment(), employee.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id = ?", id);
    }
}
