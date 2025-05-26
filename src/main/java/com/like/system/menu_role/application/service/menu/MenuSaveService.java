package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuSaveUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuCommandDbPort;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;
import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuGroup;

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
	public void save(MenuSaveDTO dto) {
		MenuGroup menuGroup = this.menuGroupDbPort.select(dto.companyCode(), dto.menuGroupCode()).orElse(null);
		Menu parent =  this.dbPort.select(dto.companyCode(), dto.menuGroupCode(), dto.parentMenuCode()).orElse(null);
		
		this.dbPort.save(MenuSaveDTOMapper.toEntity(dto, menuGroup, parent));		
	}

}
