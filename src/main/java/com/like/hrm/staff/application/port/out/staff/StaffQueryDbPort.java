package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.application.port.in.staff.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.StaffQueryResultDTO;

public interface StaffQueryDbPort {

	List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto);
	
	ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo);
}
