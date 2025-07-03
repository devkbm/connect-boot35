package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;

import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveDTO;
import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveDTOMapper;
import com.like.hrm.attendance.application.port.in.application.select.AttendanceApplicationSelectUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.system.holiday.application.port.in.query.HolidayQueryUseCase;

@Service
public class AttendanceApplicationSelectService implements AttendanceApplicationSelectUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	HolidayQueryUseCase service;
	
	AttendanceApplicationSelectService(AttendanceApplicationFormCommandDbPort dbPort, HolidayQueryUseCase service) {
		this.dbPort = dbPort;
		this.service = service;
	}
	
	@Override
	public AttendanceApplicationSaveDTO select(Long id) {
		this.dbPort.select(id);
				
		return AttendanceApplicationSaveDTOMapper.toDTO(this.dbPort.select(id).orElse(null), service);
	}

}
