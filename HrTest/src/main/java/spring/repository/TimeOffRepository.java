package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.model.TimeOff;

public interface TimeOffRepository extends JpaRepository<TimeOff, Long>{

}
