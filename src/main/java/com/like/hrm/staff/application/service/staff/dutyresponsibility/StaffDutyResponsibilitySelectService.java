package com.like.hrm.staff.application.service.staff.dutyresponsibility;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.select.StaffDutyResponsibilitySelectDTO;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.select.StaffDutyResponsibilitySelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffDutyResponsibilitySelectService implements StaffDutyResponsibilitySelectUseCase {

	StaffCommandDbPort dbPort;	
	
	StaffDutyResponsibilitySelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;		
	}

	@Override
	public StaffDutyResponsibilitySelectDTO select(String companyCode, String staffNo, Long seq) {
		Staff staff = this.dbPort.select(companyCode, staffNo)
								 .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		StaffDuty entity = staff.getStaffDutyResponsibilityList().get(staff, seq);
				
		return StaffDutyResponsibilitySelectDTO.toDTO(entity);
	}
	
	
}
