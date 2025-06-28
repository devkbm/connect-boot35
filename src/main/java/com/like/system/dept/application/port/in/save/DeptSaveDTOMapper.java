package com.like.system.dept.application.port.in.save;

import java.util.Optional;

import org.springframework.lang.Nullable;

import com.like.common.vo.LocalDatePeriod;
import com.like.system.dept.domain.Dept;

public class DeptSaveDTOMapper {

	public static DeptSaveDTO toDTO(Dept entity) {							
		
		if (entity == null) return null;
		
		Optional<Dept> parent = Optional.ofNullable(entity.getParentDept());
		Optional<LocalDatePeriod> period= Optional.ofNullable(entity.getPeriod());
		
		DeptSaveDTO dto = DeptSaveDTO.builder()
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
	
	public static Dept toEntity(DeptSaveDTO dto, @Nullable Dept parentDept) {
		if (dto.companyCode() == null) new IllegalArgumentException("조직코드가 없습니다.");
		if (dto.deptCode() == null) new IllegalArgumentException("부서코드가 없습니다.");
		
		Dept entity = Dept.builder(dto.companyCode(), dto.deptCode())									   					  
						   .deptNameKorean(dto.deptNameKorean())
						   .deptAbbreviationKorean(dto.deptAbbreviationKorean())
						   .deptNameEnglish(dto.deptNameEnglish())
						   .deptAbbreviationEnglish(dto.deptAbbreviationEnglish())
						   .period(new LocalDatePeriod(dto.fromDate(), dto.toDate()))					   
						   .seq(dto.seq())
						   .comment(dto.comment())
						   .parentDept(parentDept)
						   .parentDeptCode(parentDept == null ? null : parentDept.getId().getDeptCode())
						   .build();
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
}
