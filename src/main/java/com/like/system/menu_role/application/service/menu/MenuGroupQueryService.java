package com.like.system.menu_role.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryResultDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryResultDTOMapper;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupQueryDbPort;

@Service
public class MenuGroupQueryService implements MenuGroupQueryUseCase {

	MenuGroupQueryDbPort dbPort;
	
	MenuGroupQueryService(MenuGroupQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<MenuGroupQueryResultDTO> selectList(MenuGroupQueryDTO dto) {
		return this.dbPort.selectList(dto)
						  .stream()
						  .map(e -> MenuGroupQueryResultDTOMapper.toDTO(e))
						  .toList();
	}

}
