package com.like.hrm.staff.application.port.in.staff.license.delete;

public interface StaffLicenseDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
