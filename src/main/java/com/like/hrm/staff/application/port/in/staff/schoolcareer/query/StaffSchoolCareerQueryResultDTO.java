package com.like.hrm.staff.application.port.in.staff.schoolcareer.query;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffSchoolCareerQueryResultDTO {

	String clientAppUrl;
	String companyCode;		
	String staffNo;
	String staffName;
	Long seq;
	String schoolCareerType;
	String schoolCareerTypeName;
	String schoolCode;
	String schoolCodeName;
	LocalDate fromDate;
	LocalDate toDate;
	String majorName;
	String pluralMajorName;
	String location;
	Integer lessonYear;
	String comment;
}
