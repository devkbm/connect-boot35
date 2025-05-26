package com.like.hrm.staff.application.port.in.staff.schoolcareer;

import com.like.hrm.staff.application.dto.staff.schoolcareer.StaffSchoolCareerFormDTO;

public interface StaffSchoolCareerSelectUseCase {	
	StaffSchoolCareerFormDTO select(String companyCode, String staffNo, Long seq);
}
