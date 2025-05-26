package com.like.system.menu_role.application.port.in.role;

import com.like.system.menu_role.domain.role.Role;

public interface RoleSelectUseCase {
	Role select(String companyCode, String roleCode);
}
