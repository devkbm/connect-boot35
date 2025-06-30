package com.like.hrm.staff.application.service.staff.dutyresponsibility;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffDutyResponsibilityQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffDutyResponsibilityQueryService implements StaffDutyResponsibilityQueryUseCase {

	StaffDutyResponsibilityQueryDbPort dbPort;
	
	StaffDutyResponsibilityQueryService(StaffDutyResponsibilityQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo) {
		return this.dbPort.select(companyCode, staffNo);
	}
}
