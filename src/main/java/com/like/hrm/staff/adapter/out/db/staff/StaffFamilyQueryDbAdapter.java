package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffFamilyQuerydsl;
import com.like.hrm.staff.application.port.in.staff.family.query.StaffFamilyQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffFamilyQueryDbPort;

@Repository
public class StaffFamilyQueryDbAdapter implements StaffFamilyQueryDbPort {

	StaffFamilyQuerydsl querydsl;
	
	StaffFamilyQueryDbAdapter(StaffFamilyQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo) { 
		return querydsl.select(companyCode, staffNo);
	}

}
