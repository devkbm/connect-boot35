package com.like.system.menu_role.application.port.in.menu_role;

import java.util.List;

import com.like.system.menu_role.application.dto.menu_role.MenuRoleMappingSaveDTO;

public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
