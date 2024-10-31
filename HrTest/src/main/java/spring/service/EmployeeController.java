package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.model.Employee;
import spring.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> listAll() {
		return employeeRepository.findAll();
	}

	@PostMapping
	public Employee addingNewEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
    
}
