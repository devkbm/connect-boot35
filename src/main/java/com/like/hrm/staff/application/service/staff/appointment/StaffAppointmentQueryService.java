package com.like.hrm.staff.application.service.staff.appointment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffAppointmentQueryService implements StaffAppointmentQueryUseCase {
	
	StaffAppointmentQueryDbPort dbPort;
	
	StaffAppointmentQueryService(StaffAppointmentQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo) {
		
		return this.dbPort.select(companyCode, staffNo);
	}
}
