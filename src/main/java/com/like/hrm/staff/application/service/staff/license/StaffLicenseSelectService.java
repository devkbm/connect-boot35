package com.like.hrm.staff.application.service.staff.license;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.staff.license.StaffLicenseFormDTO;
import com.like.hrm.staff.application.port.in.staff.license.StaffLicenseSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffLicenseSelectService implements StaffLicenseSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffLicenseSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public StaffLicenseFormDTO select(String companyCode, String staffNo, Long seq) {
		Staff staff = this.dbPort.select(companyCode, staffNo)
								 .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		
		return StaffLicenseFormDTO.toDTO(staff.getLicenseList().get(staff, seq));
	}

}
