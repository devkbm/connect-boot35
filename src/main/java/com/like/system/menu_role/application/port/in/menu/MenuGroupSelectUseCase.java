package com.like.system.menu_role.application.port.in.menu;

import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;

public interface MenuGroupSelectUseCase {
	MenuGroupSaveDTO select(String companyCode, String menuGroupCode);	
}
