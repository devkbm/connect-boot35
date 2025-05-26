package com.like.hrm.staff.application.port.in.staff.license;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.license.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryUseCase {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
