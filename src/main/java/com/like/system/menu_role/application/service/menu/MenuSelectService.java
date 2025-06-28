package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.select.MenuSelectDTO;
import com.like.system.menu_role.application.port.in.menu.select.MenuSelectDTOMapper;
import com.like.system.menu_role.application.port.in.menu.select.MenuSelectUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuCommandDbPort;
import com.like.system.menu_role.domain.menu.MenuId;

@Service
public class MenuSelectService implements MenuSelectUseCase {

	MenuCommandDbPort port;
	
	MenuSelectService(MenuCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuSelectDTO select(String companyCode, String menuGroupCode, String menuCode) {
		return MenuSelectDTOMapper.toDTO(this.port.select(new MenuId(companyCode, menuGroupCode, menuCode)).orElse(null));
	}

}
