package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.save.MenuGroupSaveDTO;
import com.like.system.menu_role.application.port.in.menu.save.MenuGroupSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.save.MenuGroupSaveUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;
import com.like.system.menu_role.domain.menu.MenuGroupId;

@Service
public class MenuGroupSaveService implements MenuGroupSaveUseCase {

	MenuGroupCommandDbPort dbPort;
	
	MenuGroupSaveService(MenuGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public boolean exist(String companyCode, String menuGroupCode) {
		return this.dbPort.exist(new MenuGroupId(companyCode, menuGroupCode));
	}
	
	@Override
	public void save(MenuGroupSaveDTO dto) {
		this.dbPort.save(MenuGroupSaveDTOMapper.newMenuGroup(dto));		
	}
	
}
