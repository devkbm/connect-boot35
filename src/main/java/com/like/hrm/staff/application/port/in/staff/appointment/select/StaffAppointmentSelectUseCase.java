package com.like.hrm.staff.application.port.in.staff.appointment.select;

public interface StaffAppointmentSelectUseCase {
	StaffAppointmentRecordSelectDTO select(String companyCode, String staffNo, Long seq);	
}
