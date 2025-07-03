package com.like.hrm.staff.application.service.staff;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.query.StaffCurrentAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffQueryDbPort;

@Service
public class StaffQueryService implements StaffQueryUseCase {

	StaffQueryDbPort dbPort;
	
	StaffQueryService(StaffQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto) {
		return this.dbPort.getStaffList(dto);
	}

	@Override
	public StaffCurrentAppointmentQueryResultDTO getStaffCurrentAppointment(String companyCode, String staffNo) {
		return this.dbPort.getStaffCurrentAppointment(companyCode, staffNo);
	}

}
