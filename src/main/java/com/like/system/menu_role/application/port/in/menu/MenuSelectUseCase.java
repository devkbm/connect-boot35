package com.like.system.menu_role.application.port.in.menu;

import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;

public interface MenuSelectUseCase {
	MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode);	
}
