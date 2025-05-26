package com.like.hrm.hrmcode.application.dto.hrmcodetype;

import com.like.hrm.hrmcode.domain.HrmCodeType;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record HrmCodeTypeSaveDTO(
		String companyCode,
		String clientAppUrl,
		String typeId,
		String typeName,			
		Integer sequence,
		String comment,
		String fieldConfig
		) {
	
	public HrmCodeType newEntity() {
		return new HrmCodeType(
				this.typeId, 
		   		this.typeName,
		   		this.sequence,					   		  
		   		this.comment,
		   		this.fieldConfig
		   		);
	}
	
	public HrmCodeType modify(HrmCodeType entity) {
		entity.modify(
				this.typeName,	
				this.sequence,						 
				this.comment,
				this.fieldConfig
				);
		return entity;
	}
	
	public static HrmCodeTypeSaveDTO toDTO(HrmCodeType entity) {
		if (entity == null) return null;		
		
		return HrmCodeTypeSaveDTO.builder()
				   .typeId(entity.getId())
				   .typeName(entity.getName())					   
				   .sequence(entity.getSequence())
				   .comment(entity.getComment())
				   .fieldConfig(entity.getFieldConfig())
				   /*
				   .fieldConfig(
				   	"""
				   	[
				   	{
				   		"key" 	: "the1AddInfo",
				   		"type"	: "input",
				   		"props" : {				   			
				   			"label" : "Input",
				   			"placeholder" : "Placeholder",
				   			"description" : "Description"				   			
				   		}
				   	},
				   	{
				   		"key" 	: "the2AddInfo",
				   		"type"	: "input",
				   		"props" : {				   			
				   			"label" : "Input2",
				   			"placeholder" : "Placeholder2",
				   			"description" : "Description2"				   			
				   		}
				   	}
				   	]
				   	"""						
				    )
				    */
				   .build();						
		
	}
}