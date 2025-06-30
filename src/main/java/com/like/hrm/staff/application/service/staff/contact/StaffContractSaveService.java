package com.like.hrm.staff.application.service.staff.contact;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.contact.save.StaffContactSaveDTO;
import com.like.hrm.staff.application.port.in.staff.contact.save.StaffContactSaveDTOMapper;
import com.like.hrm.staff.application.port.in.staff.contact.save.StaffContractSaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffContactInfoCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffContractSaveService implements StaffContractSaveUseCase {

	StaffContactInfoCommandDbPort dbPort;
	StaffCommandDbPort staffDbPort;	
	
	StaffContractSaveService(StaffContactInfoCommandDbPort dbPort, StaffCommandDbPort staffDbPort) {		
		this.dbPort = dbPort;
		this.staffDbPort = staffDbPort;
	}

	@Override
	public void save(StaffContactSaveDTO dto) {
		Staff staff = staffDbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException("직원정보가 존재하지 않습니다."));;										
		
		this.dbPort.save(StaffContactSaveDTOMapper.toEntity(staff, dto));		
	}
	
}
