package com.like.system.menu_role.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuGroupQueryDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuGroupQueryUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupQueryDbPort;

@Service
public class MenuGroupQueryService implements MenuGroupQueryUseCase {

	MenuGroupQueryDbPort dbPort;
	
	MenuGroupQueryService(MenuGroupQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto) {
		return this.dbPort.selectList(dto)
						  .stream()
						  .map(e -> MenuGroupSaveDTOMapper.toDTO(e))
						  .toList();
	}

}
