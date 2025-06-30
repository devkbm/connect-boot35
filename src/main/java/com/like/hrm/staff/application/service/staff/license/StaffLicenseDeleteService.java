package com.like.hrm.staff.application.service.staff.license;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.license.delete.StaffLicenseDeleteUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffLicenseDeleteService implements StaffLicenseDeleteUseCase {

	StaffCommandDbPort dbPort;
	
	StaffLicenseDeleteService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String staffNo, Long seq) {
		Staff staff = this.dbPort.select(companyCode, staffNo)
							     .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		
		staff.getLicenseList().remove(staff, seq);
		
		this.dbPort.save(staff);
	}

}
