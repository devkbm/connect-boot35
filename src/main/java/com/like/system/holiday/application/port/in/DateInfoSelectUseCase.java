package com.like.system.holiday.application.port.in;

import java.time.LocalDate;

import com.like.system.holiday.domain.HolidayInfoCollection;

public interface DateInfoSelectUseCase {

	HolidayInfoCollection select(String companyCode, LocalDate fromDate, LocalDate toDate);
}
