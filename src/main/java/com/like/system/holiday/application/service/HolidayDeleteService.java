package com.like.system.holiday.application.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.like.system.holiday.application.port.in.delete.HolidayDeleteUseCase;
import com.like.system.holiday.application.port.out.HolidayCommandDbPort;

@Service
public class HolidayDeleteService implements HolidayDeleteUseCase {

	HolidayCommandDbPort dbPort;
	
	public HolidayDeleteService(HolidayCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, LocalDate date) {
		this.dbPort.delete(companyCode, date);		
	}

}
