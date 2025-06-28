package com.like.system.dept.application.port.in.select;

import java.util.Optional;

import com.like.common.vo.LocalDatePeriod;
import com.like.system.dept.domain.Dept;

public class DeptSelectDTOMapper {

	public static DeptSelectDTO toDTO(Dept entity) {							
		
		if (entity == null) return null;
		
		Optional<Dept> parent = Optional.ofNullable(entity.getParentDept());
		Optional<LocalDatePeriod> period= Optional.ofNullable(entity.getPeriod());
		
		DeptSelectDTO dto = DeptSelectDTO.builder()
							   .createdDt(entity.getCreatedDt())
							   .createdBy(entity.getCreatedBy().getLoggedUser())
							   .modifiedDt(entity.getModifiedDt())
							   .modifiedBy(entity.getModifiedBy().getLoggedUser())								  
							   .companyCode(entity.getId().getCompanyCode())
							   .deptCode(entity.getId().getDeptCode())
							   .parentDeptCode(parent.map(r -> r.getId().getDeptCode()).orElse(null))
							   .deptNameKorean(entity.getDeptNameKorean())
							   .deptAbbreviationKorean(entity.getDeptAbbreviationKorean())
							   .deptNameEnglish(entity.getDeptNameEnglish())
							   .deptAbbreviationEnglish(entity.getDeptAbbreviationEnglish())
							   .fromDate(period.map(LocalDatePeriod::getFrom).orElse(null))
							   .toDate(period.map(LocalDatePeriod::getTo).orElse(null))
							   .seq(entity.getSeq())
							   .comment(entity.getComment())
							   .build();		
		return dto;		
	}
	
}
