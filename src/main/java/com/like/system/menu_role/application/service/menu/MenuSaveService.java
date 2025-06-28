package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.save.MenuSaveDTO;
import com.like.system.menu_role.application.port.in.menu.save.MenuSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.save.MenuSaveUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuCommandDbPort;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;
import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.MenuGroupId;
import com.like.system.menu_role.domain.menu.MenuId;

@Service
public class MenuSaveService implements MenuSaveUseCase {

	MenuCommandDbPort dbPort;
	MenuGroupCommandDbPort menuGroupDbPort;	
	
	MenuSaveService(
			MenuCommandDbPort dbPort,
			MenuGroupCommandDbPort menuGroupDbPort	
			) {
		this.dbPort = dbPort;
		this.menuGroupDbPort = menuGroupDbPort;		
	}
	
	@Override
	public boolean exist(String companyCode, String menuGroupCode, String menuCode) {	
		return this.dbPort.exist(new MenuId(companyCode, menuGroupCode, menuCode));
	}
	
	@Override
	public void save(MenuSaveDTO dto) {
		MenuGroup menuGroup = this.menuGroupDbPort.select(new MenuGroupId(dto.companyCode(), dto.menuGroupCode())).orElse(null);
		Menu parent =  this.dbPort.select(new MenuId(dto.companyCode(), dto.menuGroupCode(), dto.parentMenuCode())).orElse(null);
		
		this.dbPort.save(MenuSaveDTOMapper.toEntity(dto, menuGroup, parent));		
	}

}
