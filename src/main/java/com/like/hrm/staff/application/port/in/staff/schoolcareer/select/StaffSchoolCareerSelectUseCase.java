package com.like.hrm.staff.application.port.in.staff.schoolcareer.select;

public interface StaffSchoolCareerSelectUseCase {	
	StaffSchoolCareerSelectDTO select(String companyCode, String staffNo, Long seq);
}
