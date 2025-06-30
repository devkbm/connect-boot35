package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.select;

public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilitySelectDTO select(String companyCode, String staffNo, Long seq);
}
