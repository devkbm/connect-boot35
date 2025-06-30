package com.like.hrm.staff.application.service.staff.schoolcareer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.schoolcareer.save.StaffSchoolCareerSaveDTO;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.save.StaffSchoolCareerSaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffSchoolCareerCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareer;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareerId;

import jakarta.persistence.EntityNotFoundException;

@Transactional
@Service
public class StaffSchoolCareerSaveService implements StaffSchoolCareerSaveUseCase {

	StaffCommandDbPort staffDbPort;
	StaffSchoolCareerCommandDbPort schoolCareerDbPort;
	
	StaffSchoolCareerSaveService(StaffCommandDbPort staffDbPort, StaffSchoolCareerCommandDbPort schoolCareerDbPort) {
		this.staffDbPort = staffDbPort;
		this.schoolCareerDbPort = schoolCareerDbPort;
	}
	
	@Override
	public void save(StaffSchoolCareerSaveDTO dto) {
		Staff staff = staffDbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));		
		StaffSchoolCareer entity = this.schoolCareerDbPort.select(new StaffSchoolCareerId(staff, dto.seq())).orElse(null);
				
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEnity(entity);
		}
		schoolCareerDbPort.save(entity);					
	}

}
