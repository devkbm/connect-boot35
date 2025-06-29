package com.like.system.systemcode.application.port.in.query;

import lombok.Builder;
import lombok.Data;

/*
@Builder
public record BizCodeTypeQueryResultDTO(
		String clientAppUrl,
		String companyCode,
		String typeId,			
		String typeName,			
		Integer sequence,
		String bizType,
		String comment
		) {

}
*/

@Data
public class BizCodeTypeQueryResultDTO {
	String clientAppUrl;
	String companyCode;
	String typeId;			
	String typeName;			
	Integer sequence;
	String bizType;
	String comment;		
}
