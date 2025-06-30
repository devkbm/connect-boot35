package com.like.hrm.staff.application.service.staff.appointment;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.appointment.select.StaffAppointmentRecordSelectDTO;
import com.like.hrm.staff.application.port.in.staff.appointment.select.StaffAppointmentRecordSelectDTOMapper;
import com.like.hrm.staff.application.port.in.staff.appointment.select.StaffAppointmentSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

@Service
public class StaffAppointmentSelectService implements StaffAppointmentSelectUseCase {

	StaffAppointmentCommandDbPort dbPort;
	
	StaffAppointmentSelectService(StaffAppointmentCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public StaffAppointmentRecordSelectDTO select(String companyCode, String staffNo, Long seq) {
		
		AppointmentRecord entity = this.dbPort.select(companyCode, staffNo, seq).orElse(null);
		
		return StaffAppointmentRecordSelectDTOMapper.toDTO(entity);
		
		//return StaffAppointmentRecordDTO.convert(this.dbPort.select(companyCode, staffNo, seq).orElse(null));
	}

	

}
