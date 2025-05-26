package com.like.hrm.staff.application.service.staff.appointment;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.staff.appointment.StaffAppointmentRecordDTO;
import com.like.hrm.staff.application.dto.staff.appointment.StaffAppointmentRecordDTOMapper;
import com.like.hrm.staff.application.port.in.staff.appointment.StaffAppointmentSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

@Service
public class StaffAppointmentSelectService implements StaffAppointmentSelectUseCase {

	StaffAppointmentCommandDbPort dbPort;
	
	StaffAppointmentSelectService(StaffAppointmentCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public StaffAppointmentRecordDTO select(String companyCode, String staffNo, Long seq) {
		
		AppointmentRecord entity = this.dbPort.select(companyCode, staffNo, seq).orElse(null);
		
		return StaffAppointmentRecordDTOMapper.toDTO(entity);
		
		//return StaffAppointmentRecordDTO.convert(this.dbPort.select(companyCode, staffNo, seq).orElse(null));
	}

	

}
