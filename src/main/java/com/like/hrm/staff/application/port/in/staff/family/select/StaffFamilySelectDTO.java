package com.like.hrm.staff.application.port.in.staff.family.select;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.family.StaffFamily;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffFamilySelectDTO(
		String clientAppUrl,
		String companyCode,			
		@NotEmpty String staffNo,
		String staffName,
		Long seq,
		String familyName,
		String familyRRN,
		String familyRelation,
		String occupation,
		String schoolCareerType,
		String comment
		) {
	
	public StaffFamily newEntity(Staff staff) {
		StaffFamily entity = StaffFamily.builder()
										.staff(staff)
										.name(familyName)
										.residentRegistrationNumber(familyRRN)
										.relation(familyRelation)
										.occupation(occupation)
										.schoolCareerType(schoolCareerType)
										.comment(comment)
										.build();
		entity.setAppUrl(clientAppUrl);
		return entity; 							
	}
	
	public void modifyEntity(StaffFamily entity) {
		entity.modifyBuilder()
		      .name(familyName)
		      .residentRegistrationNumber(familyRRN)
		      .relation(familyRelation)
		      .occupation(occupation)
		      .schoolCareerType(schoolCareerType)
		      .comment(comment)
		      .modify();		
		
		entity.setAppUrl(clientAppUrl);
	}
	
	public static StaffFamilySelectDTO toDTO(StaffFamily entity) {
		if (entity == null) return null;
		
		return StaffFamilySelectDTO.builder()		
				   .companyCode(entity.getStaff().getId().companyCode())
				   .staffNo(entity.getStaff().getId().staffNo())
				   .staffName(entity.getStaff().getName().getName())
				   .seq(entity.getId().getSeq())
				   .familyName(entity.getName())
				   .familyRRN(entity.getResidentRegistrationNumber())
				   .familyRelation(entity.getRelation())
				   .occupation(entity.getOccupation())
				   .schoolCareerType(entity.getSchoolCareerType())
				   .comment(entity.getComment())
				   .build();									 							 							 							 					
	}
}