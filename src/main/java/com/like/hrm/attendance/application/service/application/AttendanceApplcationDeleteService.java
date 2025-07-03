package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.application.port.in.application.delete.AttendanceApplcationFormDeleteUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;

@Transactional
@Service
public class AttendanceApplcationDeleteService implements AttendanceApplcationFormDeleteUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	AttendanceApplcationDeleteService(AttendanceApplicationFormCommandDbPort dbPort) { 
		this.dbPort = dbPort;
	}

	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}
}
