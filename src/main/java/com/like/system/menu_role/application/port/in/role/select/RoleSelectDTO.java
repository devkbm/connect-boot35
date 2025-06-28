package com.like.system.menu_role.application.port.in.role.select;

import lombok.Builder;

@Builder
public record RoleSelectDTO(
		String clientAppUrl,			
		String id,
		String companyCode,
		String roleCode,
		String roleName,
		String description,
		String menuGroupCode
		) {	
}
