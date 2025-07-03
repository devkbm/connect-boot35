package com.like.hrm.attendance.adapter.out.db.application.querydsl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.application.port.in.application.query.AttendanceApplicationQueryResultDTO;
import com.like.hrm.attendance.domain.application.QAttendanceApplication;
import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.domain.staff.QStaff;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class AttendanceApplicationQuerydsl {

	private final QAttendanceApplication qApplication = QAttendanceApplication.attendanceApplication;
	private final QStaff qStaff = QStaff.staff;
	private final QHrmCode hrmCode = QHrmCode.hrmCode;
	
	private JPAQueryFactory queryFactory;
	
	AttendanceApplicationQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<AttendanceApplicationQueryResultDTO> select(String staffNo) {
			
		return null;
		/*
		return queryFactory
				.select(						
					Projections.fields(AttendanceApplicationQueryResultDTO.class,
							qApplication.appId,
							qApplication.staffNo,
							qStaff.name.name.as("staffName"),
							qApplication.dutyCode,
							hrmCode.codeName.as("dutyName"),
							qApplication.dutyReason,
							qApplication.period.from.as("fromDate"),
							//qApplication.period.to.as("toDate"),																																							
							Expressions.dateTemplate(LocalDate.class, "DATEADD(DAY, {0}, {1})", Expressions.constant(1), qApplication.period.to).as("toDate") // 
					)					
				)
				.from(qApplication)
					.join(qStaff)
					.on(
						qApplication.companyCode.eq(qStaff.id.companyCode)
					.and(qApplication.staffNo.eq(qStaff.id.staffNo))
					)
					.leftJoin(hrmCode)
					.on(
						hrmCode.id.typeId.eq("HR1001")
						.and(qApplication.dutyCode.eq(hrmCode.id.code))
					)
				.where(qApplication.staffNo.eq(staffNo))
				.fetch();
		*/		
	}
}
