package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import spring.model.TimeOff;
import spring.repository.EmployeeRepository;
import spring.repository.TimeOffRepository;
import spring.service.TimeOffService;

@RestController
@RequestMapping("/api/timeoff")
public class TimeOffController {

    @Autowired
    private TimeOffService timeOffService;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TimeOffRepository timeOffRepository;
    
    @GetMapping
    public List<TimeOff> getAll() {
    	return timeOffService.findAll();
    }

    @PostMapping("/employee/{employeeId}")
    public TimeOff createRequest(@RequestBody TimeOff timeOff, @PathVariable Long employeeId) {
        TimeOff createdRequest = timeOffService.createTimeOffRequest(timeOff, employeeId);
        return timeOffRepository.save(timeOff);
    }
}
