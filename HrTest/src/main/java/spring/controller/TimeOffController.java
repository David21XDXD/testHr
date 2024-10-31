package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import spring.model.Employee;
import spring.model.TimeOff;
import spring.model.TimeOffDto;
import spring.repository.EmployeeRepository;
import spring.service.TimeOffService;

@RestController
@RequestMapping("/api/timeoff")
public class TimeOffController {

    @Autowired
    private TimeOffService timeOffService;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping
    public List<TimeOff> getAll() {
    	return timeOffService.findAll();
    }

    @PostMapping("/employee/{employeeId}")
    public TimeOff createRequest(@RequestBody TimeOffDto timeOffDto, @PathVariable Long employeeId) {
        TimeOff timeOff = new TimeOff();
        timeOff.setStartDate(timeOffDto.getStartDate());
        timeOff.setEndDate(timeOffDto.getEndDate());
        timeOff.setRequestStatus(timeOffDto.getRequestStatus());
        timeOff.setRequestDate(timeOffDto.getRequestDate());
        
        TimeOff createdRequest = timeOffService.createTimeOffRequest(timeOff, employeeId);
        return createdRequest;
    }
}
