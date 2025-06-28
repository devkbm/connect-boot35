package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.delete.MenuGroupDeleteUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;
import com.like.system.menu_role.domain.menu.MenuGroupId;

@Service
public class MenuGroupDeleteService implements MenuGroupDeleteUseCase {

	MenuGroupCommandDbPort port;
	
	MenuGroupDeleteService(MenuGroupCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode) {
		this.port.delete(new MenuGroupId(companyCode, menuGroupCode));
	}

}
