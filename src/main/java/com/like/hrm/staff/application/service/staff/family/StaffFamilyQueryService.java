package com.like.hrm.staff.application.service.staff.family;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.family.query.StaffFamilyQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.family.query.StaffFamilyQueryUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffFamilyQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffFamilyQueryService implements StaffFamilyQueryUseCase {

	StaffFamilyQueryDbPort dbPort;
	
	StaffFamilyQueryService(StaffFamilyQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo) {
		
		return this.dbPort.select(companyCode, staffNo);
	}
}
