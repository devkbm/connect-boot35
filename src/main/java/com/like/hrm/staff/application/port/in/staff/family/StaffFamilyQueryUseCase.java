package com.like.hrm.staff.application.port.in.staff.family;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.family.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryUseCase {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
