package com.like.hrm.staff.adapter.out.db.staff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.domain.staff.QStaff;
import com.like.hrm.staff.domain.staff.appointment.QAppointmentRecord;
import com.like.system.dept.domain.QDept;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class StaffAppointmentQuerydsl {

	private final QStaff qStaff = QStaff.staff;
	private final QAppointmentRecord qRecord = QAppointmentRecord.appointmentRecord;
	
	JPAQueryFactory queryFactory;
	
	StaffAppointmentQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo) {
		QHrmCode hrmCode = QHrmCode.hrmCode;
		
		QDept blngDeptCode = QDept.dept;
		QDept workDeptCode = new QDept("workDeptCode");
		
		QHrmCode jobGroupCode = new QHrmCode("jobGroupCode");
		QHrmCode jobPositionCode = new QHrmCode("jobPositionCode");
		QHrmCode occupationCode = new QHrmCode("occupationCode");
		QHrmCode jobGradeCode = new QHrmCode("jobGradeCode");
		QHrmCode payStepCode = new QHrmCode("payStepCode");
		QHrmCode jobCode = new QHrmCode("jobCode");				
		QHrmCode dutyResponsibilityCode = new QHrmCode("dutyResponsibilityCode");
		
		return queryFactory
				.select(
						Projections.fields(StaffAppointmentQueryResultDTO.class, 
								qRecord.id.companyCode,
								qRecord.id.staffNo,
								qRecord.id.staffNo.as("staffName"),
								qRecord.id.seq,
								qRecord.appointmentTypeCode,
								hrmCode.codeName.as("appointmentTypeName"),
								qRecord.appointmentDate,
								qRecord.appointmentEndDate,
								qRecord.recordName,
								qRecord.comment,
								qRecord.isCompleted,
								qRecord.info.blngDeptCode,
								blngDeptCode.deptNameKorean.as("blngDeptName"),
								qRecord.info.workDeptCode,
								workDeptCode.deptNameKorean.as("workDeptName"),
								qRecord.info.jobGroupCode,
								jobGroupCode.codeName.as("jobGroupName"),
								qRecord.info.jobPositionCode,
								jobPositionCode.codeName.as("jobPositionName"),
								qRecord.info.occupationCode,
								occupationCode.codeName.as("occupationName"),
								qRecord.info.jobGradeCode,
								jobGradeCode.codeName.as("jobGradeName"),
								qRecord.info.payStepCode,
								payStepCode.codeName.as("payStepName"),
								qRecord.info.jobCode,
								jobCode.codeName.as("jobName"),
								qRecord.info.dutyResponsibilityCode,
								dutyResponsibilityCode.codeName.as("dutyResponsibilityName")
								)
						)
				.from(qStaff)
				   .join(qRecord)
				   		.on(qStaff.id.eq(qRecord.staff.id))
				.leftJoin(blngDeptCode)
			   		.on(blngDeptCode.id.companyCode.eq(qStaff.id.companyCode)
			   		.and(blngDeptCode.id.deptCode.eq(qRecord.info.blngDeptCode)))
			   	.leftJoin(workDeptCode)
		   			.on(workDeptCode.id.companyCode.eq(qStaff.id.companyCode)
		   			.and(workDeptCode.id.deptCode.eq(qRecord.info.workDeptCode)))				   		
				.leftJoin(hrmCode)
					.on(hrmCode.id.typeId.eq("HR0000")
					.and(qRecord.appointmentTypeCode.eq(hrmCode.id.code)))
				.leftJoin(jobGroupCode)
			   		.on(jobGroupCode.id.typeId.eq("HR0001")
			   		.and(qRecord.info.jobGroupCode.eq(jobGroupCode.id.code)))
			   	.leftJoin(jobPositionCode)
			   		.on(jobPositionCode.id.typeId.eq("HR0002")
			   		.and(qRecord.info.jobPositionCode.eq(jobPositionCode.id.code)))
			   	.leftJoin(occupationCode)
			   		.on(occupationCode.id.typeId.eq("HR0003")
			   		.and(qRecord.info.occupationCode.eq(occupationCode.id.code)))
			   	.leftJoin(jobGradeCode)
			   		.on(jobGradeCode.id.typeId.eq("HR0004")
			   		.and(qRecord.info.jobGradeCode.eq(jobGradeCode.id.code)))
			   	.leftJoin(payStepCode)
			   		.on(payStepCode.id.typeId.eq("HR0005")
			   		.and(qRecord.info.payStepCode.eq(payStepCode.id.code)))
			   	.leftJoin(jobCode)
			   		.on(jobCode.id.typeId.eq("HR0006")
			   		.and(qRecord.info.jobCode.eq(jobCode.id.code)))
			   	.leftJoin(dutyResponsibilityCode)
			   		.on(dutyResponsibilityCode.id.typeId.eq("HR0007")
			   		.and(qRecord.info.dutyResponsibilityCode.eq(dutyResponsibilityCode.id.code)))					
				.where(qStaff.id.companyCode.eq(companyCode)
						 .and(qStaff.id.staffNo.eq(staffNo)))
				.fetch();
	}
	
}
