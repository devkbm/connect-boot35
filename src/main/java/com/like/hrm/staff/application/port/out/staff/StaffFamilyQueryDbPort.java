package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.port.in.staff.family.query.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryDbPort {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
