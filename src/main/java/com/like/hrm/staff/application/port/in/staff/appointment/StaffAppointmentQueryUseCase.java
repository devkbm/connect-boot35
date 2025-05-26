package com.like.hrm.staff.application.port.in.staff.appointment;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.appointment.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
