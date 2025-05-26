package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuGroupSelectUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;

@Service
public class MenuGroupSelectService implements MenuGroupSelectUseCase {

	MenuGroupCommandDbPort port;
	
	MenuGroupSelectService(MenuGroupCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuGroupSaveDTO select(String companyCode, String menuGroupCode) {
		return MenuGroupSaveDTOMapper.toDTO(this.port.select(companyCode, menuGroupCode).orElse(null));
	}

}
