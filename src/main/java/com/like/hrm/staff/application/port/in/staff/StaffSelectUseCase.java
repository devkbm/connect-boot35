package com.like.hrm.staff.application.port.in.staff;

import com.like.hrm.staff.application.dto.staff.ResponseStaff;

public interface StaffSelectUseCase {
	ResponseStaff select(String companyCode, String staffNo);
}
