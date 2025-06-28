package com.like.system.menu_role.application.port.in.menu.hierarchy;

import java.util.List;

public interface MenuHierarchySelectUseCase {

	List<MenuHierarchyNgZorro> select(String companyCode, String menuGroupCode);	
}
