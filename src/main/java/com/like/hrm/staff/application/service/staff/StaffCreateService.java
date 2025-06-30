package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.StaffCreateDTO;
import com.like.hrm.staff.application.port.in.staff.StaffCreateUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffName;
import com.like.hrm.staff.domain.staff.StaffNoCreateStrategy;

import jakarta.persistence.EntityExistsException;

@Service
public class StaffCreateService implements StaffCreateUseCase {

	StaffCommandDbPort dbPort;
	
	StaffCreateService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void create(StaffCreateDTO dto) {
		if (isExistStaff(dto.companyCode(), dto.staffNo())) throw new EntityExistsException("동일 직원번호가 존재합니다 : " + dto.getStaffId());

		StaffNoCreateStrategy strategy = () -> dto.staffNo();
		
		Staff staff = new Staff(dto.companyCode()
				               ,strategy
				               ,new StaffName(dto.name(), dto.nameEng(), dto.nameEng())
				               ,dto.residentRegistrationNumber());
									
		dbPort.save(staff);
	}
	
	private boolean isExistStaff(String companyCode, String staffNo) {
		return dbPort.select(companyCode, staffNo).isPresent();
	}

}
