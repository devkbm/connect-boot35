package com.like.hrm.staff.application.port.in.staff.schoolcareer.query;

import java.util.List;

public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
