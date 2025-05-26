package com.like.system.menu_role.application.dto.role;

public record RoleSaveDTO(
		String clientAppUrl,			
		String id,
		String companyCode,
		String roleCode,
		String roleName,
		String description,
		String menuGroupCode
		) {	
}
