package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationFormDTO;
import com.like.hrm.attendance.application.dto.application.AttendanceApplicationFormDTOMapper;
import com.like.hrm.attendance.application.port.in.application.AttendanceApplicationFormSelectUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.system.holiday.application.port.in.DateInfoSelectUseCase;

@Service
public class AttendanceApplicationFormSelectService implements AttendanceApplicationFormSelectUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	DateInfoSelectUseCase service;
	
	AttendanceApplicationFormSelectService(AttendanceApplicationFormCommandDbPort dbPort, DateInfoSelectUseCase service) {
		this.dbPort = dbPort;
		this.service = service;
	}
	
	@Override
	public AttendanceApplicationFormDTO select(Long id) {
		this.dbPort.select(id);
				
		return AttendanceApplicationFormDTOMapper.toDTO(this.dbPort.select(id).orElse(null), service);
	}

}
