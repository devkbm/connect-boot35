package com.like.hrm.staff.application.service.staff.family;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.family.save.StaffFamilySaveDTO;
import com.like.hrm.staff.application.port.in.staff.family.save.StaffFamilySaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffFamilyCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.family.StaffFamily;
import com.like.hrm.staff.domain.staff.family.StaffFamilyId;

import jakarta.persistence.EntityNotFoundException;

@Transactional
@Service
public class StaffFamilySaveService implements StaffFamilySaveUseCase {

	StaffCommandDbPort staffDbPort;
	StaffFamilyCommandDbPort familyDbPort;
	
	StaffFamilySaveService(StaffCommandDbPort staffDbPort, StaffFamilyCommandDbPort familyDbPort) {
		this.staffDbPort = staffDbPort;
		this.familyDbPort = familyDbPort;
	}
	
	@Override
	public void save(StaffFamilySaveDTO dto) {
		Staff staff = this.staffDbPort.select(dto.companyCode(), dto.staffNo())
								 	  .orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));
		StaffFamily entity = familyDbPort.select(new StaffFamilyId(staff, dto.seq())).orElse(null);
		
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEntity(entity);
		}
		this.familyDbPort.save(entity);					
	}

}
