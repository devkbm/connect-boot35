package com.like.system.holiday.application.port.out;

import java.time.LocalDate;
import java.util.List;

import com.like.system.holiday.domain.Holiday;

public interface HolidayQueryDbPort {
	List<Holiday> selectList(String companyCode, LocalDate fromDate, LocalDate toDate);
}
