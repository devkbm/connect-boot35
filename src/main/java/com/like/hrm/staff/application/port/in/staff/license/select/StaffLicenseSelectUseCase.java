package com.like.hrm.staff.application.port.in.staff.license.select;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseSelectDTO select(String companyCode, String staffNo, Long seq);
}
