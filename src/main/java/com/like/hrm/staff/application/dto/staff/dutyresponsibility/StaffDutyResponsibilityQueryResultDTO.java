package com.like.hrm.staff.application.dto.staff.dutyresponsibility;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDutyResponsibilityQueryResultDTO {

	String companyCode;			
	String staffNo;
	String staffName;
	Long seq;
	String dutyResponsibilityCode;
	String dutyResponsibilityName;
	LocalDate fromDate;
	LocalDate toDate;
	Boolean isPayApply;
}
