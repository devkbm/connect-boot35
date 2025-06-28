package com.like.system.menu_role.application.port.out.menu;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuId;

public interface MenuCommandDbPort {
	boolean exist(MenuId id);
	
	Optional<Menu> select(MenuId id);
	
	void save(Menu dto);
	
	void delete(MenuId id);
}
