package com.like.hrm.staff.adapter.out.db.staff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.application.port.in.staff.family.query.StaffFamilyQueryResultDTO;
import com.like.hrm.staff.domain.staff.family.QStaffFamily;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class StaffFamilyQuerydsl {

	private final QStaffFamily qFamily = QStaffFamily.staffFamily;
		
	JPAQueryFactory queryFactory;
	
	StaffFamilyQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
		
	public List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo) {
 
		QHrmCode hrmCode = QHrmCode.hrmCode;
		
		return queryFactory
				.select(
						Projections.fields(StaffFamilyQueryResultDTO.class, 
							qFamily.id.companyCode,
							qFamily.id.staffNo,
							qFamily.id.staffNo.as("staffName"),
							qFamily.id.seq,
							qFamily.name.as("familyName"),
							qFamily.residentRegistrationNumber.as("familyRRN"),
							qFamily.relation.as("familyRelationCode"),
							hrmCode.codeName.as("familyRelationName"),
							qFamily.occupation,
							qFamily.schoolCareerType,
							qFamily.comment
					))
				.from(qFamily)
					.leftJoin(hrmCode)
					.on(hrmCode.id.typeId.eq("HR0008")
					.and(qFamily.relation.eq(hrmCode.id.code)))
				.where(qFamily.id.companyCode.eq(companyCode)
				  .and(qFamily.id.staffNo.eq(staffNo)))
				.fetch();
	}
}
