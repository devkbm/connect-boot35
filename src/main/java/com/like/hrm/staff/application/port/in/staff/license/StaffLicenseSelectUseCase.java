package com.like.hrm.staff.application.port.in.staff.license;

import com.like.hrm.staff.application.dto.staff.license.StaffLicenseFormDTO;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseFormDTO select(String companyCode, String staffNo, Long seq);
}
