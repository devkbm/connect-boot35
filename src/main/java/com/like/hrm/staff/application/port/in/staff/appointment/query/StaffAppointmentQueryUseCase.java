package com.like.hrm.staff.application.port.in.staff.appointment.query;

import java.util.List;

public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
