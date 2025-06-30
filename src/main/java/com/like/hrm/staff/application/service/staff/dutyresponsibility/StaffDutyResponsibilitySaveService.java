package com.like.hrm.staff.application.service.staff.dutyresponsibility;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.save.StaffDutyResponsibilitySaveDTO;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.save.StaffDutyResponsibilitySaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffDutyResponsibilityCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDutyId;

import jakarta.persistence.EntityNotFoundException;

@Transactional
@Service
public class StaffDutyResponsibilitySaveService implements StaffDutyResponsibilitySaveUseCase {

	StaffCommandDbPort staffDbPort;
	StaffDutyResponsibilityCommandDbPort dutyDbPort;
	
	StaffDutyResponsibilitySaveService(StaffCommandDbPort staffDbPort, StaffDutyResponsibilityCommandDbPort dutyDbPort) {
		this.staffDbPort = staffDbPort;
		this.dutyDbPort = dutyDbPort;
	}
	
	@Override
	public void save(StaffDutyResponsibilitySaveDTO dto) {
		Staff staff = this.staffDbPort.select(dto.companyCode(), dto.staffNo())
								 .orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));
		StaffDuty entity = this.dutyDbPort.select(new StaffDutyId(staff, dto.seq())).orElse(null);
		
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEntity(entity);
		}
		this.dutyDbPort.save(entity);				
	}

}
