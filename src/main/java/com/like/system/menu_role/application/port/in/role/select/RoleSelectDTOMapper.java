package com.like.system.menu_role.application.port.in.role.select;

import com.like.system.menu_role.domain.role.Role;

public class RoleSelectDTOMapper {
	
	public static RoleSelectDTO toDTO(Role entity) {
				
		return RoleSelectDTO
				.builder()
				.clientAppUrl(entity.getAppUrl())
				.id(entity.getId().getRoleCode())
				.companyCode(entity.getCompanyCode())
				.roleCode(entity.getRoleCode())
				.roleName(entity.getRoleName())
				.description(entity.getDescription())
				.menuGroupCode(entity.getMenuGroupCode())
				.build();
	}
	
}
