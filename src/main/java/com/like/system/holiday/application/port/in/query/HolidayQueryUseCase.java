package com.like.system.holiday.application.port.in.query;

import java.time.LocalDate;

import com.like.system.holiday.domain.HolidayInfoCollection;

public interface HolidayQueryUseCase {

	HolidayInfoCollection select(String companyCode, LocalDate fromDate, LocalDate toDate);
}
