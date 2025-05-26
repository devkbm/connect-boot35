package com.like.hrm.staff.application.dto.staff;

import java.time.LocalDate;

import com.like.hrm.staff.domain.staff.Staff;

public record ResponseStaff(			
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
			
	public static ResponseStaff toDTO(Staff entity) {
		
		if (entity == null) return null;			
		
		var name = entity.getName();
		
		return new ResponseStaff(entity.getId().companyCode()
								,entity.getId().staffNo()
							   	,name.getName()
							   	,name.getNameEng()
							   	,name.getNameChi()
							   	,entity.getResidentRegistrationNumber().getNumber()
							   	,entity.getGender()
							   	,entity.getBirthday()
							   	,entity.getImagePath());								   
							   
	}
}