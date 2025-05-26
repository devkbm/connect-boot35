package com.like.system.menu_role.application.port.in.menu;

import java.util.List;

import com.like.system.menu_role.application.dto.menu.MenuGroupQueryDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;

public interface MenuGroupQueryUseCase {
	List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto);
}
