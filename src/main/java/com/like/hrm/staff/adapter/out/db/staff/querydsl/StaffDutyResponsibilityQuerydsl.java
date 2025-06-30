package com.like.hrm.staff.adapter.out.db.staff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryResultDTO;
import com.like.hrm.staff.domain.staff.dutyresponsibility.QStaffDuty;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class StaffDutyResponsibilityQuerydsl {

	private final QStaffDuty qDuty = QStaffDuty.staffDuty;
	
	JPAQueryFactory queryFactory;
	
	StaffDutyResponsibilityQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo) {
		QHrmCode hrmCode = QHrmCode.hrmCode;
		
		return queryFactory
				.select(
						Projections.fields(StaffDutyResponsibilityQueryResultDTO.class, 
								qDuty.id.companyCode,
								qDuty.id.staffNo,
								qDuty.id.staffNo.as("staffName"),
								qDuty.id.seq,								
								qDuty.dutyResponsibilityCode,
								hrmCode.codeName.as("dutyResponsibilityName"),
								qDuty.fromDate,
								qDuty.toDate,
								qDuty.isPayApply
							)
					)
				.from(qDuty)
					.leftJoin(hrmCode)
					.on(hrmCode.id.typeId.eq("HR0008")
					.and(qDuty.dutyResponsibilityCode.eq(hrmCode.id.code)))
				.where(qDuty.id.companyCode.eq(companyCode)
				  .and(qDuty.id.staffNo.eq(staffNo)))
				.fetch();
	}
}
