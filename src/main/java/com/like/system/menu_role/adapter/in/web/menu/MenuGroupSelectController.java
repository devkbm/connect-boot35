package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.menu.select.MenuGroupSelectDTO;
import com.like.system.menu_role.application.port.in.menu.select.MenuGroupSelectUseCase;

@RestController
public class MenuGroupSelectController {
	
	private MenuGroupSelectUseCase useCase;		
			
	public MenuGroupSelectController(MenuGroupSelectUseCase useCase) {
		this.useCase = useCase;		
	}
			
	@GetMapping("/api/system/menugroup/{menuGroupCode}")
	public ResponseEntity<?> getMenuGroup(@RequestParam String companyCode, @PathVariable String menuGroupCode) {				
		
		MenuGroupSelectDTO dto = useCase.select(companyCode, menuGroupCode);				
								
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}					
	
}
