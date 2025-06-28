package com.like.system.menu_role.application.port.in.role.save;

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
