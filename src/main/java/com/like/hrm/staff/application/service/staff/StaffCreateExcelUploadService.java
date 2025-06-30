package com.like.hrm.staff.application.service.staff;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.StaffCreateExcelUploadDTO;
import com.like.hrm.staff.application.port.in.staff.StaffCreateExcelUploadUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffName;
import com.like.hrm.staff.domain.staff.StaffNoCreateStrategy;

import jakarta.persistence.EntityExistsException;

@Service
public class StaffCreateExcelUploadService implements StaffCreateExcelUploadUseCase {

	StaffCommandDbPort dbPort;
	
	StaffCreateExcelUploadService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public void upload(List<StaffCreateExcelUploadDTO> dtos) {
		for ( StaffCreateExcelUploadDTO dto : dtos ) {
			if (isExistStaff(dto.getCompanyCode(), dto.getStaffNo())) throw new EntityExistsException("동일 직원번호가 존재합니다 : " + dto.getStaffNo());
			
			StaffNoCreateStrategy strategy = () -> dto.getStaffNo();
			
			Staff staff = new Staff(dto.getCompanyCode()
					               ,strategy
					               ,new StaffName(dto.getName(), dto.getNameEng(), dto.getNameEng())
					               ,dto.getResidentRegistrationNumber());
										
			dbPort.save(staff);
		}
		
	}
	
	private boolean isExistStaff(String companyCode, String staffNo) {
		return dbPort.select(companyCode, staffNo).isPresent();
	}
	
}
