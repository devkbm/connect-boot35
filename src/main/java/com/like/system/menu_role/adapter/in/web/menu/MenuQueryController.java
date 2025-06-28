package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.common.dto.HtmlSelectOptionRecord;
import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryResultDTO;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryUseCase;
import com.like.system.menu_role.domain.menu.MenuType;

import jakarta.validation.Valid;

@RestController
public class MenuQueryController {

	MenuQueryUseCase useCase;
	
	MenuQueryController(MenuQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/menu")
	public ResponseEntity<?> getMenuList(@Valid MenuQueryDTO dto) {				
		
		List<MenuQueryResultDTO> dtoList = useCase.selectList(dto);																	
		
		return toList(dtoList, MessageUtil.getQueryMessage(dtoList.size()));
	}
	
	@GetMapping("/api/system/menu/menutype")
	public ResponseEntity<?> getMenuTypeList() {				
		
		List<HtmlSelectOptionRecord> list = new ArrayList<HtmlSelectOptionRecord>();
		
		for (MenuType menuType : MenuType.values()) {			
			list.add(new HtmlSelectOptionRecord(menuType.getLabel(), menuType.toString()));
		}
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	
}
