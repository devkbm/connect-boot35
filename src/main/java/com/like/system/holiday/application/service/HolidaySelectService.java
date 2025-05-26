package com.like.system.holiday.application.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.like.system.holiday.application.dto.HolidaySaveDTO;
import com.like.system.holiday.application.dto.HolidaySaveDTOMapper;
import com.like.system.holiday.application.port.in.HolidaySelectUseCase;
import com.like.system.holiday.application.port.out.HolidaySelectPort;

@Service
public class HolidaySelectService implements HolidaySelectUseCase {

	HolidaySelectPort port;
	
	public HolidaySelectService(HolidaySelectPort port) {
		this.port = port;
	}
	
	@Override
	public HolidaySaveDTO select(String companyCode, LocalDate date) {		
		return HolidaySaveDTOMapper.toDTO(this.port.select(companyCode, date));
	}
	
}
