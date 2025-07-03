package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffQueryQuerydsl;
import com.like.hrm.staff.application.port.in.staff.query.StaffCurrentAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffQueryDbPort;

@Repository
public class StaffQueryDbAdapter implements StaffQueryDbPort {

	StaffQueryQuerydsl repository;
	
	StaffQueryDbAdapter(StaffQueryQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto) {
		return this.repository.getStaffList(dto);
	}

	@Override
	public StaffCurrentAppointmentQueryResultDTO getStaffCurrentAppointment(String companyCode, String staffNo) {
		return this.repository.getStaffCurrentAppointment(companyCode, staffNo);
	}

}
