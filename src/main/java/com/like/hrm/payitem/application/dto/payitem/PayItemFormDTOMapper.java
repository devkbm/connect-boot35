package com.like.hrm.payitem.application.dto.payitem;

import com.like.hrm.payitem.domain.PayItem;
import com.like.hrm.payitem.domain.PayItemId;

public class PayItemFormDTOMapper {

	public static PayItemFormDTO toDTO(PayItem entity) {
		
		if (entity == null) return null;
		
		return PayItemFormDTO
				.builder()
				.companyCode(entity.getId().getCompanyCode())
				.itemCode(entity.getId().getItemCode())
				.type(entity.getType())
				.usePayTable(entity.getUsePayTable())
				.seq(entity.getSeq())
				.comment(entity.getComment())
				.build(); 		
	}
	
	public static PayItem newEntity(PayItemFormDTO dto) {
		
		return new PayItem(
				new PayItemId(dto.companyCode(), dto.itemCode()),
				dto.itemName(),
				dto.type(),
				dto.usePayTable(),
				dto.seq(),
				dto.comment()
				);
	}
	
	public static PayItem modifyEntity(PayItem entity, PayItemFormDTO dto) {
		entity.modify(
				dto.itemName(), 
				dto.type(),
				dto.usePayTable(),
				dto.seq(),
				dto.comment()
				);
		
		return entity;
	}
}
