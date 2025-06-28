package com.like.system.holiday.application.port.in.select;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record HolidaySelectDTO(
		String companyCode,
		String clientAppUrl,
		LocalDate date,
		String holidayName,			
		String comment
		) {		
}
