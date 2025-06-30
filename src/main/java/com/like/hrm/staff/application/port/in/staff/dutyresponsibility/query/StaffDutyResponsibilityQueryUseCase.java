package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query;

import java.util.List;

public interface StaffDutyResponsibilityQueryUseCase {

	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
