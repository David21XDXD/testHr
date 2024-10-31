package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
