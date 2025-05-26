package com.like.system.menu_role.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuQueryDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuQueryUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuQueryDbPort;

@Service
public class MenuQueryService implements MenuQueryUseCase {

	MenuQueryDbPort dbPort;
	
	MenuQueryService(MenuQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<MenuSaveDTO> selectList(MenuQueryDTO dto) {
		return this.dbPort.selectList(dto)
						  .stream()
					  	  .map(e -> MenuSaveDTOMapper.toDTO(e))
						  .toList();
	}
}
