package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryDbPort {
	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
