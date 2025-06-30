package com.like.hrm.staff.application.service.staff.schoolcareer;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffSchoolCareerQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffSchoolCareerQueryService implements StaffSchoolCareerQueryUseCase {

	StaffSchoolCareerQueryDbPort dbPort;
	
	StaffSchoolCareerQueryService(StaffSchoolCareerQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo) {			
		return dbPort.select(companyCode, staffNo);		
	}
}
