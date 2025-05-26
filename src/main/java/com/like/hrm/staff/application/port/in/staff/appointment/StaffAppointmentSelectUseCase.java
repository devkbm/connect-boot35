package com.like.hrm.staff.application.port.in.staff.appointment;

import com.like.hrm.staff.application.dto.staff.appointment.StaffAppointmentRecordDTO;

public interface StaffAppointmentSelectUseCase {
	StaffAppointmentRecordDTO select(String companyCode, String staffNo, Long seq);	
}
