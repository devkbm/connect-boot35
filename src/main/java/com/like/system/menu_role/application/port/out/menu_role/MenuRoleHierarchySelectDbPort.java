package com.like.system.menu_role.application.port.out.menu_role;

import java.util.List;

import com.like.system.menu_role.domain.menu_role.MenuRoleHierarchy;

public interface MenuRoleHierarchySelectDbPort {
	List<MenuRoleHierarchy> select(String companyCode, String menuGroupCode, String roleCode);
}
