package com.like.hrm.staff.application.service.staff.license;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.license.save.StaffLicenseSaveDTO;
import com.like.hrm.staff.application.port.in.staff.license.save.StaffLicenseSaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffLicenseCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.license.StaffLicense;
import com.like.hrm.staff.domain.staff.license.StaffLicenseId;

import jakarta.persistence.EntityNotFoundException;

@Transactional
@Service
public class StaffLicenseSaveService implements StaffLicenseSaveUseCase {

	StaffCommandDbPort staffDbPort;
	StaffLicenseCommandDbPort licenseDbPort;
	
	StaffLicenseSaveService(StaffCommandDbPort staffDbPort, StaffLicenseCommandDbPort licenseDbPort) {
		this.staffDbPort = staffDbPort;
		this.licenseDbPort = licenseDbPort;
	}
	
	@Override
	public void save(StaffLicenseSaveDTO dto) {
		Staff staff = this.staffDbPort.select(dto.companyCode(), dto.staffNo())
								 	  .orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));
		StaffLicense entity = this.licenseDbPort.select(new StaffLicenseId(staff, dto.seq())).orElse(null);
		
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEntity(entity);
		}
		this.licenseDbPort.save(entity);					
	}

}
