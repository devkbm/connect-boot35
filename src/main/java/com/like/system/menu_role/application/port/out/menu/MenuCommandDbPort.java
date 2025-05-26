package com.like.system.menu_role.application.port.out.menu;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.Menu;

public interface MenuCommandDbPort {
	Optional<Menu> select(String companyCode, String menuGroupCode, String menuCode);
	
	void save(Menu dto);
	
	void delete(String companyCode, String menuGroupCode, String menuCode);
}
