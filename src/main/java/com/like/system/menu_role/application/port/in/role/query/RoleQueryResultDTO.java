package com.like.system.menu_role.application.port.in.role.query;

import lombok.Data;

/*
public record RoleQueryResultDTO(
		String clientAppUrl,					
		String companyCode,
		String roleCode,
		String roleName,
		String description,
		String menuGroupCode
		) {	
}
*/
@Data
public class RoleQueryResultDTO {
	String clientAppUrl;					
	String companyCode;
	String roleCode;
	String roleName;
	String description;
	String menuGroupCode;
}