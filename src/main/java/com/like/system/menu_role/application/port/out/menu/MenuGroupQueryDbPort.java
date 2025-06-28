package com.like.system.menu_role.application.port.out.menu;

import java.util.List;

import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryDTO;
import com.like.system.menu_role.domain.menu.MenuGroup;

public interface MenuGroupQueryDbPort {
	List<MenuGroup> selectList(MenuGroupQueryDTO dto);
}
