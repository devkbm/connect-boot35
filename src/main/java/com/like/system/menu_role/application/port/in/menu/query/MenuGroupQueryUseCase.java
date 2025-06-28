package com.like.system.menu_role.application.port.in.menu.query;

import java.util.List;

public interface MenuGroupQueryUseCase {
	List<MenuGroupQueryResultDTO> selectList(MenuGroupQueryDTO dto);
}
