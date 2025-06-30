package com.like.hrm.staff.application.port.in.staff.family.select;

public interface StaffFamilySelectUseCase {	
	StaffFamilySelectDTO select(String companyCode, String staffNo, Long seq);
}

