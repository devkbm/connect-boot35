package com.like.hrm.staff.adapter.out.db.staff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryResultDTO;
import com.like.hrm.staff.domain.staff.schoolcareer.QStaffSchoolCareer;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class StaffSchoolCareerQuerydsl {

	private final QStaffSchoolCareer qCareer = QStaffSchoolCareer.staffSchoolCareer;
	
	JPAQueryFactory queryFactory;
	
	StaffSchoolCareerQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo) {
		
		
		QHrmCode school = QHrmCode.hrmCode;			// HR0010
		QHrmCode career = new QHrmCode("career");;	// HR0009
							
		return queryFactory
				.select(
						Projections.fields(StaffSchoolCareerQueryResultDTO.class, 
							qCareer.id.companyCode,
							qCareer.id.staffNo,
							qCareer.id.staffNo.as("staffName"),
							qCareer.id.seq,							
							qCareer.schoolCareerType,
							career.codeName.as("schoolCareerTypeName"),
							qCareer.schoolCode,
							school.codeName.as("schoolCodeName"),
							qCareer.period.from.as("fromDate"),
							qCareer.period.to.as("toDate"),
							qCareer.majorName,
							qCareer.pluralMajorName,
							qCareer.location,
							qCareer.lessonYear,
							qCareer.comment
					))
				.from(qCareer)
					.leftJoin(career)
					.on(career.id.typeId.eq("HR0009")
					.and(qCareer.schoolCareerType.eq(career.id.code)))
					.leftJoin(school)
					.on(school.id.typeId.eq("HR0010")
					.and(qCareer.schoolCode.eq(school.id.code)))
				.where(qCareer.id.companyCode.eq(companyCode)
				  .and(qCareer.id.staffNo.eq(staffNo)))
				.fetch();				
	}
}
