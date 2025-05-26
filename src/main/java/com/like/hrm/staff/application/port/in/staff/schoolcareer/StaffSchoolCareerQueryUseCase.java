package com.like.hrm.staff.application.port.in.staff.schoolcareer;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.schoolcareer.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
