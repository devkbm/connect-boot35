package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffSchoolCareerQuerydsl;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffSchoolCareerQueryDbPort;

@Repository
public class StaffSchoolCareerQueryDbAdapter implements StaffSchoolCareerQueryDbPort {

	StaffSchoolCareerQuerydsl querydsl;
	
	StaffSchoolCareerQueryDbAdapter(StaffSchoolCareerQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo) {
		return this.querydsl.select(companyCode, staffNo);
	}

}
