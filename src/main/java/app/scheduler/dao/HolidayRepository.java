package app.scheduler.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.scheduler.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
	
	List<Holiday> findByHolidayDateBetween(LocalDate start, LocalDate end);
}
