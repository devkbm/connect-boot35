package com.like.hrm.staff.application.port.in.staff.dutyresponsibility;

import com.like.hrm.staff.application.dto.staff.dutyresponsibility.StaffDutyResponsibilityFormDTO;

public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilityFormDTO select(String companyCode, String staffNo, Long seq);
}
