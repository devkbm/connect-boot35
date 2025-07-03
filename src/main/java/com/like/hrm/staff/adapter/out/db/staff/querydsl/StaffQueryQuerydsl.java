package com.like.hrm.staff.adapter.out.db.staff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.staff.application.port.in.staff.query.QStaffCurrentAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffCurrentAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryResultDTO;
import com.like.hrm.staff.domain.staff.QStaff;
import com.like.system.dept.domain.QDept;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;


@Repository
public class StaffQueryQuerydsl {

	private JPAQueryFactory queryFactory;	
	private final QStaff qStaff = QStaff.staff;
	
	public StaffQueryQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
		
	public List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto) {
		return queryFactory
				.select(Projections.fields(
						StaffQueryResultDTO.class, 
						qStaff.id.companyCode,
						qStaff.id.staffNo,
						qStaff.name.name,
						qStaff.name.nameEng,
						qStaff.name.nameChi,
						qStaff.residentRegistrationNumber.number,
						qStaff.gender,
						qStaff.birthday,
						qStaff.imagePath
						)
				)
				.from(qStaff)
				.fetch();
	}
		
	public StaffCurrentAppointmentQueryResultDTO getStaffCurrentAppointment(String companyCode, String staffNo) {

		QDept blngDeptCode = QDept.dept;
		QDept workDeptCode = new QDept("workDeptCode");
		
		QHrmCode jobGroupCode = QHrmCode.hrmCode;
		QHrmCode jobPositionCode = new QHrmCode("jobPositionCode");
		QHrmCode occupationCode = new QHrmCode("occupationCode");
		QHrmCode jobGradeCode = new QHrmCode("jobGradeCode");
		QHrmCode payStepCode = new QHrmCode("payStepCode");
		QHrmCode jobCode = new QHrmCode("jobCode");			
				
		return queryFactory.select(projectionCurrentAppointment(
											qStaff,
											blngDeptCode,
											workDeptCode,
											jobGroupCode,
											jobPositionCode,
											occupationCode,
											jobGradeCode,
											payStepCode,
											jobCode
											)
									)				
					.from(qStaff)				
					.leftJoin(blngDeptCode)
						.on(blngDeptCode.id.companyCode.eq(qStaff.id.companyCode)
			   			.and(blngDeptCode.id.deptCode.eq(qStaff.currentAppointment.blngDeptCode)))
					.leftJoin(workDeptCode)
			   			.on(workDeptCode.id.companyCode.eq(qStaff.id.companyCode)
			   			.and(workDeptCode.id.deptCode.eq(qStaff.currentAppointment.workDeptCode)))
			   		.leftJoin(jobGroupCode)
				   		.on(jobGroupCode.id.typeId.eq("HR0001")
				   		.and(qStaff.currentAppointment.jobGroupCode.eq(jobGroupCode.id.code)))
				   	.leftJoin(jobPositionCode)
				   		.on(jobPositionCode.id.typeId.eq("HR0002")
				   		.and(qStaff.currentAppointment.jobPositionCode.eq(jobPositionCode.id.code)))
				   	.leftJoin(occupationCode)
				   		.on(occupationCode.id.typeId.eq("HR0003")
				   		.and(qStaff.currentAppointment.occupationCode.eq(occupationCode.id.code)))
				   	.leftJoin(jobGradeCode)
				   		.on(jobGradeCode.id.typeId.eq("HR0004")
				   		.and(qStaff.currentAppointment.jobGradeCode.eq(jobGradeCode.id.code)))
				   	.leftJoin(payStepCode)
				   		.on(payStepCode.id.typeId.eq("HR0005")
				   		.and(qStaff.currentAppointment.payStepCode.eq(payStepCode.id.code)))
				   	.leftJoin(jobCode)
				   		.on(jobCode.id.typeId.eq("HR0006")
				   		.and(qStaff.currentAppointment.jobCode.eq(jobCode.id.code)))				   
				   	.where(qStaff.id.companyCode.eq(companyCode)
					  .and(qStaff.id.staffNo.eq(staffNo)))
				   	.fetchFirst();				   	
	}
			
	
	private QStaffCurrentAppointmentQueryResultDTO projectionCurrentAppointment(
			QStaff qStaff,	
			QDept blngDeptCode,
			QDept workDeptCode,
			QHrmCode jobGroupCode,
			QHrmCode jobPositionCode,
			QHrmCode occupationCode,
			QHrmCode jobGradeCode,
			QHrmCode payStepCode,
			QHrmCode jobCode
			) {
		return new QStaffCurrentAppointmentQueryResultDTO(
				qStaff.id.companyCode,
				qStaff.id.staffNo,
				qStaff.currentAppointment.blngDeptCode,
				blngDeptCode.deptNameKorean,
				qStaff.currentAppointment.workDeptCode,
				workDeptCode.deptNameKorean,
				qStaff.currentAppointment.jobGroupCode,
				jobGroupCode.codeName,
				qStaff.currentAppointment.jobPositionCode,
				jobPositionCode.codeName,
				qStaff.currentAppointment.occupationCode,
				occupationCode.codeName,
				qStaff.currentAppointment.jobGradeCode,
				jobGradeCode.codeName,
				qStaff.currentAppointment.payStepCode,
				payStepCode.codeName,
				qStaff.currentAppointment.jobCode,
				jobCode.codeName
		);
	}
	
	

}
