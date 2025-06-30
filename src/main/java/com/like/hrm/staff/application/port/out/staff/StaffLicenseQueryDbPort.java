package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.port.in.staff.license.query.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryDbPort {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
