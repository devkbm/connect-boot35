package com.like.system.holiday.application.port.in.select;

import java.time.LocalDate;

public interface HolidaySelectUseCase {
	HolidaySelectDTO select(String companyCode, LocalDate date);
}
