package com.like.hrm.staff.application.port.in.staff.dutyresponsibility;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.dutyresponsibility.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryUseCase {

	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
