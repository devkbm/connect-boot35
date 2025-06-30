package com.like.hrm.staff.application.port.in.staff.license.query;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffLicenseQueryResultDTO {
	
	String clientAppUrl;
	String companyCode;			
	String staffNo;
	String staffName;
	Long seq;
	String licenseType;
	String licenseTypeName;
	String licenseNumber;
	LocalDate dateOfAcquisition;
	String certificationAuthority;
	String comment;
}
