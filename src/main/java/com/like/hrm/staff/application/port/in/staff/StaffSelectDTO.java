package com.like.hrm.staff.application.port.in.staff;

import java.time.LocalDate;

import com.like.hrm.staff.domain.staff.Staff;

public record StaffSelectDTO(			
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
			
	public static StaffSelectDTO toDTO(Staff entity) {
		
		if (entity == null) return null;			
		
		var name = entity.getName();
		
		return new StaffSelectDTO(entity.getId().companyCode()
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