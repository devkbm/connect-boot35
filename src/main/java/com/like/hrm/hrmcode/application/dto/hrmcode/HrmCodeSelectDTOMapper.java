package com.like.hrm.hrmcode.application.dto.hrmcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeType;

public class HrmCodeSelectDTOMapper {

		
	public static Map<String, Object> stringToMap(String str) throws JsonMappingException, JsonProcessingException {
		if (!StringUtils.hasText(str)) return null;
					
		return new ObjectMapper().readValue(str, new TypeReference<HashMap<String, Object>>() {});
	}
	
	public static HrmCodeSelectDTO toDTO(HrmCode entity, HrmCodeType codeType) throws JsonMappingException, JsonProcessingException {
		if (entity == null) return null;
									
		Map<String, Object> extraInfo = new HashMap<>();
		
		if (StringUtils.hasText(entity.getExtraInfo())) {
			extraInfo = stringToMap(entity.getExtraInfo());
		}
									
		return HrmCodeSelectDTO
				.builder()
				.typeId(entity.getId().getTypeId())
				.code(entity.getId().getCode())
				.codeName(entity.getCodeName())
				.useYn(entity.isUseYn())
				.sequence(entity.getSequence())
				.comment(entity.getComment())
				.extraInfo(extraInfo)
				.fieldConfig(codeType.getFieldConfig())
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
