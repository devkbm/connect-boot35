package com.like.system.menu_role.application.port.out.menu;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.MenuGroup;

public interface MenuGroupCommandDbPort {

	Optional<MenuGroup> select(String companyCode, String menuGroupCode);
	
	void save(MenuGroup entity);
	
	void delete(String companyCode, String menuGroupCode);
}
