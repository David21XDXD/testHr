package spring.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.model.RequestStatus;
import spring.model.TimeOff;
import spring.repository.TimeOffRepository;

@Service
public class TimeOffService {

    @Autowired
    private TimeOffRepository timeOffRepository;

    @Transactional
    public TimeOff createTimeOffRequest(TimeOff timeOff) {
        timeOff.setRequestDate(LocalDate.now());
        timeOff.setRequestStatus(RequestStatus.PENDING);
        return timeOffRepository.save(timeOff);
    }

	public List<TimeOff> findAll() {
		return timeOffRepository.findAll();
	}
}
