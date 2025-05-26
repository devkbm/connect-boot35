package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuGroupSaveUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;

@Service
public class MenuGroupSaveService implements MenuGroupSaveUseCase {

	MenuGroupCommandDbPort port;
	
	MenuGroupSaveService(MenuGroupCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(MenuGroupSaveDTO dto) {
		this.port.save(MenuGroupSaveDTOMapper.newMenuGroup(dto));		
	}

}
