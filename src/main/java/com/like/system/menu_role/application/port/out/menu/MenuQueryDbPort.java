package com.like.system.menu_role.application.port.out.menu;

import java.util.List;

import com.like.system.menu_role.application.dto.menu.MenuQueryDTO;
import com.like.system.menu_role.domain.menu.Menu;

public interface MenuQueryDbPort {
	List<Menu> selectList(MenuQueryDTO dto);
}
