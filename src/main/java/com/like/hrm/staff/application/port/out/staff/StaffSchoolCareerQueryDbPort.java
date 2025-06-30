package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryDbPort {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
