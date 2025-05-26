package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

public interface StaffAppointmentCommandDbPort {
	Optional<AppointmentRecord> select(String companyCode, String staffNo, Long seq);	

	AppointmentRecord save(AppointmentRecord entity);
	
	void delete(String companyCode, String staffNo, Long seq);
}
