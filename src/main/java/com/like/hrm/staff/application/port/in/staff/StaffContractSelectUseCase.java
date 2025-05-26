package com.like.hrm.staff.application.port.in.staff;

import com.like.hrm.staff.application.dto.staff.contact.StaffContactSaveDTO;

public interface StaffContractSelectUseCase {

	StaffContactSaveDTO select(String companyCode, String staffNo);
}
