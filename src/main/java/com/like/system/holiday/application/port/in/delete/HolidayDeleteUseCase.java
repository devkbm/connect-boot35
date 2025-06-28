package com.like.system.holiday.application.port.in.delete;

import java.time.LocalDate;

public interface HolidayDeleteUseCase {
	void delete(String companyCode, LocalDate date);
}
