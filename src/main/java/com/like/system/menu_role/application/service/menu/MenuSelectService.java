package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuSelectUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuCommandDbPort;

@Service
public class MenuSelectService implements MenuSelectUseCase {

	MenuCommandDbPort port;
	
	MenuSelectService(MenuCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode) {
		return MenuSaveDTOMapper.toDTO(this.port.select(companyCode, menuGroupCode, menuCode).orElse(null));
	}

}
