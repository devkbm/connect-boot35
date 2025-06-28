package com.like.system.menu_role.application.port.in.menu.query;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MenuGroupQueryResultDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,	
		String clientAppUrl,			
		String companyCode,
		String menuGroupCode,		
		String menuGroupName,
		String menuGroupUrl,
		String description,
		Long sequence
		) implements Serializable {		
}
