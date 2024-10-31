package spring.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;


@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String title;
    @Positive
    private double salary;
    @Past
    private LocalDate employeeTimestamp;
    
    
	public Employee() {
    	
    }
    
	public Employee(String name, double salary, LocalDate employeeTimestamp) {
    	super();
    	this.name = name;
    	this.salary = salary;
    	this.employeeTimestamp = employeeTimestamp;
    }

    public LocalDate getEmployeeTimestamp() {
		return employeeTimestamp;
	}
	public void setEmployeeTimestamp(LocalDate employeeTimestamp) {
		this.employeeTimestamp = employeeTimestamp;
	}
	public Long getEmployeeId() {
    	return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
    	this.employeeId = employeeId;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public double getSalary() {
    	return salary;
    }
    public void setSalary(double salary) {
    	this.salary = salary;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
    
    
}