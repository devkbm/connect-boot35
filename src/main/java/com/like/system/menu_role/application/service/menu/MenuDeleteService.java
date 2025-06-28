package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.delete.MenuDeleteUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuCommandDbPort;
import com.like.system.menu_role.domain.menu.MenuId;

@Service
public class MenuDeleteService implements MenuDeleteUseCase {

	MenuCommandDbPort port;
	
	MenuDeleteService(MenuCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode, String menuCode) {
		this.port.delete(new MenuId(companyCode, menuGroupCode, menuCode));		
	}

}
