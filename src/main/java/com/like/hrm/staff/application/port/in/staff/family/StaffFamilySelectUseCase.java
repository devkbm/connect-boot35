package com.like.hrm.staff.application.port.in.staff.family;

import com.like.hrm.staff.application.dto.staff.family.StaffFamilyFormDTO;

public interface StaffFamilySelectUseCase {	
	StaffFamilyFormDTO select(String companyCode, String staffNo, Long seq);
}

