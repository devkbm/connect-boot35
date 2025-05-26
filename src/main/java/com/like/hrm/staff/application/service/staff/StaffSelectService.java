package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.staff.ResponseStaff;
import com.like.hrm.staff.application.port.in.staff.StaffSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;

@Service
public class StaffSelectService implements StaffSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public ResponseStaff select(String companyCode, String staffNo) {
		return ResponseStaff.toDTO(this.dbPort.select(companyCode, staffNo).orElse(null));
	}
	
}
