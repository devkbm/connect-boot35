package com.like.hrm.hrmcode.application.dto.hrmcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record HrmCodeSaveDTO(
		String companyCode,
		String clientAppUrl,
		String typeId,
		String code,
		String codeName,
		boolean useYn,
		Integer sequence,
		String comment,
		Map<String, Object> extraInfo
		) {
	
	public HrmCode newEntity() throws JsonProcessingException {
						
		return new HrmCode(
				new HrmCodeId(typeId, code),										
				this.codeName,
		  		this.useYn,
		   		this.sequence,
		   		this.comment,
		   		mapToString(this.extraInfo)
				);
	}
		
	public HrmCode modify(HrmCode entity) throws JsonProcessingException {		
		
		entity.modify(
				this.codeName,
				this.useYn,
				this.sequence,
				this.comment,
				mapToString(this.extraInfo)
				);
		return entity;
	}
	
	private String mapToString(Map<String, Object> mapValue) throws JsonProcessingException {
		
		
		return new ObjectMapper().writeValueAsString(mapValue);
	}
	
	public static Map<String, Object> stringToMap(String str) throws JsonMappingException, JsonProcessingException {
		if (!StringUtils.hasText(str)) return null;
					
		return new ObjectMapper().readValue(str, new TypeReference<HashMap<String, Object>>() {});
	}

	public static HrmCodeSaveDTO toDTO(HrmCode entity) throws JsonMappingException, JsonProcessingException {
		if (entity == null) return null;
									
		Map<String, Object> extraInfo = new HashMap<>();
		
		if (StringUtils.hasText(entity.getExtraInfo())) {
			extraInfo = stringToMap(entity.getExtraInfo());
		}
									
		return HrmCodeSaveDTO
				.builder()
				.typeId(entity.getId().getTypeId())
				.code(entity.getId().getCode())
				.codeName(entity.getCodeName())
				.useYn(entity.isUseYn())
				.sequence(entity.getSequence())
				.comment(entity.getComment())
				.extraInfo(extraInfo)				
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