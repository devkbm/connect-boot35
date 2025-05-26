package com.like.system.menu_role.export;

import java.util.List;

public interface MenuHierarchyByRolesSelectUseCase {

	List<MenuHierarchyNgZorroDTO> select(String companyCode, String menuGroupCode, List<String> roleCodes);
}
