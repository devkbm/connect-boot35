package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffDutyResponsibilityQuerydsl;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffDutyResponsibilityQueryDbPort;

@Repository
public class StaffDutyResponsibilityQueryDbAdapter implements StaffDutyResponsibilityQueryDbPort {

	StaffDutyResponsibilityQuerydsl querydsl;
	
	StaffDutyResponsibilityQueryDbAdapter(StaffDutyResponsibilityQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo) {
		return querydsl.select(companyCode, staffNo);
	}

}
