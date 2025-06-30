package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.save;

import java.time.LocalDate;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffDutyResponsibilitySaveDTO(
		String clientAppUrl,
		String companyCode,			
		String staffNo,
		String staffName,
		Long seq,
		String dutyResponsibilityCode,
		String dutyResponsibilityName,
		LocalDate fromDate,
		LocalDate toDate,
		Boolean isPayApply			
		) {
	
	public StaffDuty newEntity(Staff staff) {		
		StaffDuty entity = StaffDuty.builder()
									.staff(staff)
									.dutyResponsibilityCode(dutyResponsibilityCode)
									.fromDate(fromDate)
									.toDate(toDate)
									.isPayApply(isPayApply)
									.build(); 									
							
		entity.setAppUrl(clientAppUrl);
		
		return entity;
	}
	
	public void modifyEntity(StaffDuty entity) {
		entity.modifyBuilder()
			  .dutyResponsibilityCode(dutyResponsibilityCode)
			  .fromDate(fromDate)
			  .toDate(toDate)
			  .isPayApply(isPayApply)
			  .modify();
		
		//entity.modifyEntity(dutyResponsibilityCode, fromDate, toDate, isPayApply);
		
		entity.setAppUrl(clientAppUrl);
	}
	
	
	public static StaffDutyResponsibilitySaveDTO toDTO(StaffDuty entity) {			
		if (entity == null) return null;
		
		return StaffDutyResponsibilitySaveDTO.builder()
				   .companyCode(entity.getStaff().getId().companyCode())
				   .staffNo(entity.getStaff().getId().staffNo())
				   .staffName(entity.getStaff().getName().getName())
				   .seq(entity.getId().getSeq())
				   .dutyResponsibilityCode(entity.getDutyResponsibilityCode())
				   .dutyResponsibilityName(entity.getDutyResponsibilityCode())
				   .fromDate(entity.getFromDate())
				   .toDate(entity.getToDate())
				   .isPayApply(entity.getIsPayApply())
				   .build();
	}
	
}