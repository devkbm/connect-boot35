package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.port.in.staff.query.StaffCurrentAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryResultDTO;

public interface StaffQueryDbPort {

	List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto);
	
	StaffCurrentAppointmentQueryResultDTO getStaffCurrentAppointment(String companyCode, String staffNo);
}
