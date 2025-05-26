package com.like.system.menu_role.application.port.in.menu;

import java.util.List;

import com.like.system.menu_role.application.dto.menu.MenuQueryDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;

public interface MenuQueryUseCase {
	List<MenuSaveDTO> selectList(MenuQueryDTO dto);
}
