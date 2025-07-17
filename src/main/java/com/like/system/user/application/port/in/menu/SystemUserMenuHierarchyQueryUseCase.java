package com.like.system.user.application.port.in.menu;

import java.util.List;

import com.like.system.menu_role.export.MenuHierarchyNgZorroDTO;

public interface SystemUserMenuHierarchyQueryUseCase {
	List<MenuHierarchyNgZorroDTO> select(String companyCode, String userId, String menuGroupCode);
}
