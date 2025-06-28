package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryResultDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryUseCase;

@RestController
public class MenuGroupQueryController {

	MenuGroupQueryUseCase useCase;
	
	MenuGroupQueryController(MenuGroupQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/menugroup")
	public ResponseEntity<?> getMenuGroupList(MenuGroupQueryDTO dto) {				
		
		List<MenuGroupQueryResultDTO> dtoList = useCase.selectList(dto); 																								 
		
		return toList(dtoList, MessageUtil.getQueryMessage(dtoList.size()));
	}
}
