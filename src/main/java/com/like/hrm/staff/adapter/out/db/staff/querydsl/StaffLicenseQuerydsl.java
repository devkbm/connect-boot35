package com.like.hrm.staff.adapter.out.db.staff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.application.port.in.staff.license.query.StaffLicenseQueryResultDTO;
import com.like.hrm.staff.domain.staff.license.QStaffLicense;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class StaffLicenseQuerydsl {
	
	private final QStaffLicense qLicense = QStaffLicense.staffLicense;
	
	JPAQueryFactory queryFactory;
	
	StaffLicenseQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
		
	public List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo) {
	
		QHrmCode hrmCode = QHrmCode.hrmCode;
		
		return queryFactory
				.select(
						Projections.fields(StaffLicenseQueryResultDTO.class, 
							qLicense.id.companyCode,
							qLicense.id.staffNo,
							qLicense.id.staffNo.as("staffName"),
							qLicense.id.seq,							
							qLicense.licenseType,
							hrmCode.codeName.as("licenseTypeName"),
							qLicense.licenseNumber,
							qLicense.dateOfAcquisition,
							qLicense.certificationAuthority,
							qLicense.comment
					))
				.from(qLicense)
					.leftJoin(hrmCode)
					.on(hrmCode.id.typeId.eq("HR0011")
					.and(qLicense.licenseType.eq(hrmCode.id.code)))
				.where(qLicense.id.companyCode.eq(companyCode)
				  .and(qLicense.id.staffNo.eq(staffNo)))
				.fetch();
	}
}
