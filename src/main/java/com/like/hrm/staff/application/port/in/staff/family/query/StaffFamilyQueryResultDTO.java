package com.like.hrm.staff.application.port.in.staff.family.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffFamilyQueryResultDTO {
		String clientAppUrl;
		String companyCode;			
		String staffNo;
		String staffName;
		Long seq;
		String familyName;
		String familyRRN;
		String familyRelationCode;
		String familyRelationName;
		String occupation;
		String schoolCareerType;
		String comment;				
}