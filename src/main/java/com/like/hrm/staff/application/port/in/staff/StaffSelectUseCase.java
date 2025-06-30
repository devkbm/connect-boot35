package com.like.hrm.staff.application.port.in.staff;

public interface StaffSelectUseCase {
	StaffSelectDTO select(String companyCode, String staffNo);
}
