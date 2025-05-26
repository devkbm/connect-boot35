package com.like.hrm.staff.application.port.in.staff.license;

public interface StaffLicenseDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
