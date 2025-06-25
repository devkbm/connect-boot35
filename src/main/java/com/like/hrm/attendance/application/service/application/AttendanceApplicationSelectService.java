package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationDTO;
import com.like.hrm.attendance.application.dto.application.AttendanceApplicationDTOMapper;
import com.like.hrm.attendance.application.port.in.application.AttendanceApplicationFormSelectUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.system.holiday.application.port.in.DateInfoSelectUseCase;

@Service
public class AttendanceApplicationSelectService implements AttendanceApplicationFormSelectUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	DateInfoSelectUseCase service;
	
	AttendanceApplicationSelectService(AttendanceApplicationFormCommandDbPort dbPort, DateInfoSelectUseCase service) {
		this.dbPort = dbPort;
		this.service = service;
	}
	
	@Override
	public AttendanceApplicationDTO select(Long id) {
		this.dbPort.select(id);
				
		return AttendanceApplicationDTOMapper.toDTO(this.dbPort.select(id).orElse(null), service);
	}

}
