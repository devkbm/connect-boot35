package com.like.hrm.staff.application.service.staff;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.StaffImageUploadUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffImageUploadService implements StaffImageUploadUseCase {
	
	StaffCommandDbPort dbPort;	
	
	StaffImageUploadService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;	
	}	

	@Override
	public String saveUploadImagePath(String companyCode, String staffNo, File file) throws IOException {
		Staff entity = this.dbPort.select(companyCode, staffNo)
				  .orElseThrow(() -> new EntityNotFoundException("직원정보가 존재하지 않습니다."));;

		if (entity == null) return null;

		String path = file.getCanonicalPath();
		
		entity.changeImagePath(path);

		this.dbPort.save(entity);
		
		return path;
	}

}
