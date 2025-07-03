package com.like.hrm.staff.application.port.in.staff.query;

import java.time.LocalDate;

import lombok.Data;

/*
public record StaffQueryResultDTO(			
		String companyCode,
		String staffNo,
		String name,
		String nameEng,
		String nameChi,
		String residentRegistrationNumber,
		String gender,
		LocalDate birthday,
		String imagePath
		) {
			
}
*/
@Data
public class StaffQueryResultDTO {			
	String companyCode;
	String staffNo;
	String name;
	String nameEng;
	String nameChi;
	String residentRegistrationNumber;
	String gender;
	LocalDate birthday;
	String imagePath;			
}