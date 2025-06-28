package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.menu.select.MenuSelectDTO;
import com.like.system.menu_role.application.port.in.menu.select.MenuSelectUseCase;

@RestController
public class MenuSelectController {
	
	private MenuSelectUseCase useCase;		
			
	public MenuSelectController(MenuSelectUseCase useCase) {
		this.useCase = useCase;		
	}				
	
	@GetMapping("/api/system/menugroup/{menuGroupCode}/menu/{menuCode}")
	public ResponseEntity<?> getMenu(
			@RequestParam String companyCode,
			@PathVariable String menuGroupCode,
			@PathVariable String menuCode
			) {				
		
		MenuSelectDTO dto = useCase.select(companyCode, menuGroupCode, menuCode);					
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
		
}
