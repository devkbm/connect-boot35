package com.like.hrm.staff.application.port.in.staff.family.query;

import java.util.List;

public interface StaffFamilyQueryUseCase {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
