package com.like.hrm.staff.application.port.in.staff.license.query;

import java.util.List;

public interface StaffLicenseQueryUseCase {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
