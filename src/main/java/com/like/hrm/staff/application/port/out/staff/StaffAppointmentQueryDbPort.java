package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryDbPort {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
