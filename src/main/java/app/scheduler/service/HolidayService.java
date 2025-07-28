package app.scheduler.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import app.scheduler.dao.HolidayRepository;
import app.scheduler.entity.Holiday;

@Service
public class HolidayService {

	private HolidayRepository holidayRepository;

	public HolidayService(HolidayRepository holidayRepository) {
		this.holidayRepository = holidayRepository;
	}

	public LocalDate getFirstWorkingDayOfMonth(int year, int month) {
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate lastDayOfMonth = LocalDate.of(year, month, firstDayOfMonth.lengthOfMonth());

		List<Holiday> holidaysOfMonth = holidayRepository.findByHolidayDateBetween(firstDayOfMonth, lastDayOfMonth);
		LocalDate current = firstDayOfMonth;
		while(Boolean.TRUE) {
			boolean isWeekend = (current.getDayOfWeek() == DayOfWeek.SATURDAY || current.getDayOfWeek() == DayOfWeek.SUNDAY);
			
		}
		

		return current;
	}
}
