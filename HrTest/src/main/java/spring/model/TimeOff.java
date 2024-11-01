package spring.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TimeOff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestId;
	private LocalDate startDate;
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;
	private LocalDate requestDate;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public TimeOff() {
	}

	public TimeOff(LocalDate startDate, LocalDate endDate, RequestStatus requestStatus, LocalDate requestDate,
			Employee employee) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.requestStatus = requestStatus;
		this.requestDate = requestDate;
		this.employee = employee;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeOff other = (TimeOff) obj;
		return requestId == other.requestId;
	}

}