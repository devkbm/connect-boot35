package com.like.system.menu_role.application.port.out.menu_role;

import java.util.List;

import com.like.system.menu_role.domain.menu_role.MenuRoleMapping;

public interface MenuRoleMappingSaveDbPort {

	void clear(String orgnizationCode, String menuGroupCode, String roleCode);
	
	void save(List<MenuRoleMapping> entityList);
}
