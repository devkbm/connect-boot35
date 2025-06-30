package com.like.hrm.staff.application.port.in.staff.contact.select;

public interface StaffContractSelectUseCase {

	StaffContactSelectDTO select(String companyCode, String staffNo);
}
