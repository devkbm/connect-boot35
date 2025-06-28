package com.like.system.holiday.application.service;

import org.springframework.stereotype.Service;

import com.like.system.holiday.application.port.in.save.HolidaySaveDTO;
import com.like.system.holiday.application.port.in.save.HolidaySaveDTOMapper;
import com.like.system.holiday.application.port.in.save.HolidaySaveUseCase;
import com.like.system.holiday.application.port.out.HolidayCommandDbPort;

@Service
public class HolidaySaveService implements HolidaySaveUseCase {

	HolidayCommandDbPort dbPort;
	
	public HolidaySaveService(HolidayCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(HolidaySaveDTO dto) {	
		this.dbPort.save(HolidaySaveDTOMapper.newEntity(dto));
	}

}
