package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffQueryQuerydsl;
import com.like.hrm.staff.application.dto.staff.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.application.port.in.staff.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.StaffQueryResultDTO;
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
	public ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo) {
		return this.repository.getStaffCurrentAppointment(companyCode, staffNo);
	}

}
