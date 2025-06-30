package com.like.hrm.staff.application.service.staff.contact;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.contact.select.StaffContactSelectDTO;
import com.like.hrm.staff.application.port.in.staff.contact.select.StaffContactSelectDTOMapper;
import com.like.hrm.staff.application.port.in.staff.contact.select.StaffContractSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

@Service
public class StaffContractSelectService implements StaffContractSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffContractSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public StaffContactSelectDTO select(String companyCode, String staffNo) {
		Staff staff = dbPort.select(companyCode, staffNo).orElse(null);
		
		return StaffContactSelectDTOMapper.toDTO(staff);
	}
}
