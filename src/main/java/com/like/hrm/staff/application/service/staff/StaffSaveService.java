package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.StaffSaveDTO;
import com.like.hrm.staff.application.port.in.staff.StaffSaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffSaveService implements StaffSaveUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSaveService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(StaffSaveDTO dto) {
		Staff staff = this.dbPort.select(dto.companyCode(), dto.staffNo())				
								 .orElseThrow(() -> new EntityNotFoundException("직원정보가 존재하지 않습니다."));
		
		dto.modifyEntity(staff);
		
		dbPort.save(staff);		
	}

}
