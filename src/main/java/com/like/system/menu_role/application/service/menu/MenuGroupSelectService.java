package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.select.MenuGroupSelectDTO;
import com.like.system.menu_role.application.port.in.menu.select.MenuGroupSelectDTOMapper;
import com.like.system.menu_role.application.port.in.menu.select.MenuGroupSelectUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;
import com.like.system.menu_role.domain.menu.MenuGroupId;

@Service
public class MenuGroupSelectService implements MenuGroupSelectUseCase {

	MenuGroupCommandDbPort port;
	
	MenuGroupSelectService(MenuGroupCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuGroupSelectDTO select(String companyCode, String menuGroupCode) {
		return MenuGroupSelectDTOMapper.toDTO(this.port.select(new MenuGroupId(companyCode, menuGroupCode)).orElse(null));
	}

}
