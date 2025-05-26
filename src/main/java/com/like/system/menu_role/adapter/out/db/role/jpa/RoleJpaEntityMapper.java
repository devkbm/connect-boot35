package com.like.system.menu_role.adapter.out.db.role.jpa;

import com.like.system.menu_role.domain.role.Role;
//import com.like.system.menu_role.adapter.out.db.role.jpa.QRoleJpaEntity;

public class RoleJpaEntityMapper {

	public static RoleJpaEntity toJpaEntity(Role entity) {
		return new RoleJpaEntity(entity.getCompanyCode()
						  ,entity.getRoleCode()
						  ,entity.getRoleName()
						  ,entity.getDescription()
						  ,entity.getMenuGroupCode());
	}
	
	public static Role toEntity(RoleJpaEntity jpaEntity) {
		if (jpaEntity == null) return null; 
		
		return new Role(
				jpaEntity.getModifiedAppUrl(),
				jpaEntity.getCompanyCode(),
				jpaEntity.getRoleCode(),
				jpaEntity.getRoleName(),
				jpaEntity.getDescription(),
				jpaEntity.getMenuGroupCode()
				);			
	}
	
	
}
