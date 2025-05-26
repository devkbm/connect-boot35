package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.StaffDeleteUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;

@Service
public class StaffDeleteService implements StaffDeleteUseCase {

	StaffCommandDbPort dbPort;
	
	StaffDeleteService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String id) {
		this.dbPort.delete(companyCode, id);		
	}

}
