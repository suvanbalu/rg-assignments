package net.suvan.employeespring;

import net.suvan.employeespring.model.Employee;
import net.suvan.employeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeSpringApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
