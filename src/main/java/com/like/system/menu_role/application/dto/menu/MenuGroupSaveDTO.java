package com.like.system.menu_role.application.dto.menu;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MenuGroupSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,	
		String clientAppUrl,			
		String companyCode,
		String menuGroupCode,		
		String menuGroupName,
		String menuGroupUrl,
		String description
		) implements Serializable {		
}
