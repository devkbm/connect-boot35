package com.like.hrm.staff.application.port.in.staff.appointment.query;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffAppointmentQueryResultDTO {

	String companyCode;	
	String staffNo;
	String staffName;			
	Long seq;
	String appointmentTypeCode;
	String appointmentTypeName;
	LocalDate appointmentDate;
	LocalDate appointmentEndDate;			
	String recordName;
	String comment;				
	Boolean isCompleted;
	String blngDeptCode;
	String blngDeptName;
	String workDeptCode;			
	String workDeptName;
	String jobGroupCode;			
	String jobGroupName;
	String jobPositionCode;			
	String jobPositionName;
	String occupationCode;			
	String occupationName;
	String jobGradeCode;
	String jobGradeName;
	String payStepCode;		
	String payStepName;
	String jobCode;			
	String jobName;
	String dutyResponsibilityCode;
	String dutyResponsibilityName;
}
