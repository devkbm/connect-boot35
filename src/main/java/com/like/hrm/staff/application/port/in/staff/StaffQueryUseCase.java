package com.like.hrm.staff.application.port.in.staff;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.ResponseStaffCurrentAppointment;

public interface StaffQueryUseCase {

	List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto);
	
	ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo);
}
