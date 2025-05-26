package com.like.hrm.staff.application.port.in.staff.license;

import com.like.hrm.staff.application.dto.staff.license.StaffLicenseFormDTO;

public interface StaffLicenseSaveUseCase {

	void save(StaffLicenseFormDTO dto);
}
