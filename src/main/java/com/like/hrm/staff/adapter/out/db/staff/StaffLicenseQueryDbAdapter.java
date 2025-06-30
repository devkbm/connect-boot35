package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffLicenseQuerydsl;
import com.like.hrm.staff.application.port.in.staff.license.query.StaffLicenseQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffLicenseQueryDbPort;

@Repository
public class StaffLicenseQueryDbAdapter implements StaffLicenseQueryDbPort {

	StaffLicenseQuerydsl querydsl;
	
	StaffLicenseQueryDbAdapter(StaffLicenseQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo) {
		return querydsl.select(companyCode, staffNo);
	}

}
