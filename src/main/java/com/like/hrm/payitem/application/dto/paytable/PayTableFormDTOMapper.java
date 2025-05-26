package com.like.hrm.payitem.application.dto.paytable;

import com.like.hrm.payitem.domain.PayTable;

public class PayTableFormDTOMapper {

	public static PayTableFormDTO toDTO(PayTable entity) {
		if (entity == null) return null;
				
		return PayTableFormDTO
				.builder()
				.id(entity.getId())
				.companyCode(entity.getCompanyCode())
				.payItemCode(entity.getPayItemCode())
				.occupationCode(entity.getOccupationCode())
				.jobGradeCode(entity.getJobGradeCode())
				.payStepCode(entity.getPayStepCode())
				.wageAmount(entity.getWageAmount())
				.isEnable(entity.getIsEnable())
				.comment(entity.getComment())
				.build();
	}
	
	public static PayTable newEnity(PayTableFormDTO dto) {
		return new PayTable(
				dto.companyCode(),
				dto.payItemCode(),
				dto.occupationCode(),
				dto.jobGradeCode(),
				dto.payStepCode(),
				dto.wageAmount(),
				dto.isEnable(),
				dto.comment()
				);
	}
	
	public static PayTable modify(PayTable entity, PayTableFormDTO dto) {
		entity.modify(
				dto.wageAmount(), 
				dto.isEnable(), 
				dto.comment()
				);
		
		return entity;
	}
	
}
