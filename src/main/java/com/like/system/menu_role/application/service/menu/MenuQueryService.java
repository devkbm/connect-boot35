package com.like.system.menu_role.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.query.MenuQueryDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryResultDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryResultDTOMapper;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuQueryDbPort;

@Service
public class MenuQueryService implements MenuQueryUseCase {

	MenuQueryDbPort dbPort;
	
	MenuQueryService(MenuQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<MenuQueryResultDTO> selectList(MenuQueryDTO dto) {
		return this.dbPort.selectList(dto)
						  .stream()
					  	  .map(e -> MenuQueryResultDTOMapper.toDTO(e))
						  .toList();
	}
}
