package com.like.system.menu_role.application.port.in.role.save;

import com.like.system.menu_role.domain.role.Role;

public class RoleSaveDTOMapper {
	
	public static Role newEntity(RoleSaveDTO dto) {
		Role entity = new Role(
				dto.clientAppUrl(),
				dto.companyCode(), 
				dto.roleCode(), 
				dto.roleName(), 
				dto.description(), 
				dto.menuGroupCode()
				);
					
		return entity;
	}
	
	public static void modifyEntity(Role entity, RoleSaveDTO dto) {		
		entity.modify(
				dto.clientAppUrl(),
				dto.roleName(), 
				dto.description(), 
				dto.menuGroupCode()
				);		
	}
}
