package com.like.system.menu_role.application.port.out.menu;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.MenuGroupId;

public interface MenuGroupCommandDbPort {

	boolean exist(MenuGroupId id);
	
	Optional<MenuGroup> select(MenuGroupId id);
	
	void save(MenuGroup entity);
	
	void delete(MenuGroupId id);
}
