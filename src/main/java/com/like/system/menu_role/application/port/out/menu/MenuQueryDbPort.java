package com.like.system.menu_role.application.port.out.menu;

import java.util.List;

import com.like.system.menu_role.application.port.in.menu.query.MenuQueryDTO;
import com.like.system.menu_role.domain.menu.Menu;

public interface MenuQueryDbPort {
	List<Menu> selectList(MenuQueryDTO dto);
}
