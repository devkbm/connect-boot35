package com.like.system.holiday.application.port.in.select;

import com.like.system.holiday.domain.Holiday;

public class HolidaySelectDTOMapper {

	public static HolidaySelectDTO toDTO(Holiday entity) {
		if (entity == null) return null;
		
		return HolidaySelectDTO
					.builder()
					.companyCode(entity.getId().getCompanyCode())
					.date(entity.getId().getDate())
					.holidayName(entity.getHolidayName())
					.comment(entity.getComment())
					.build(); 
	}
		
}
