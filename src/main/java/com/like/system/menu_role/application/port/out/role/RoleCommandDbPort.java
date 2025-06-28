package com.like.system.menu_role.application.port.out.role;

import java.util.Optional;

import com.like.system.menu_role.domain.role.Role;

public interface RoleCommandDbPort {
	
	boolean exists(String companyCode, String roleCode);
	
	Optional<Role> find(String companyCode, String roleCode);
	
	void save(Role entity);
	
	void delete(String companyCode, String roleCode);
}
