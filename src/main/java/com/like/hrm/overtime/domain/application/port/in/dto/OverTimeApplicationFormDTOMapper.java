package com.like.hrm.overtime.domain.application.port.in.dto;

import com.like.hrm.overtime.domain.application.OverTimeApplication;

public class OverTimeApplicationFormDTOMapper {

	public static OverTimeApplicationFormDTO toDTO(OverTimeApplication e) {
		if (e == null) return null;
		
		return OverTimeApplicationFormDTO				
				.builder()
				.ovtmId(e.getOvtmId())
				.companyCode(e.getCompanyCode())
				.staffNo(e.getStaffNo())
				.from(e.getFrom())
				.to(e.getTo())
				.contents(e.getContents())
				.location(e.getLocation())
				.build();
	}
	
	public static OverTimeApplication newEntity(OverTimeApplicationFormDTO dto) {
		return new OverTimeApplication(
				dto.companyCode(),
				dto.staffNo(),
				dto.from(),
				dto.to(),
				dto.contents(),
				dto.location()
				);
	}
	
	public static void modifyEntity(OverTimeApplication e, OverTimeApplicationFormDTO dto) {				
		e.modify(
				dto.from(),
				dto.to(),
				dto.contents(),
				dto.location()
				);
	}
	
}
