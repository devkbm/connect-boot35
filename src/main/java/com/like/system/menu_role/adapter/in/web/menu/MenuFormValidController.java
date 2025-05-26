package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;
import com.like.system.menu_role.application.port.in.menu.MenuSelectUseCase;

@RestController
public class MenuFormValidController {

	private MenuSelectUseCase useCase;
	
	public MenuFormValidController(MenuSelectUseCase useCase) {
		this.useCase = useCase;		
	}

	@GetMapping("/api/system/menugroup/{menuGroupId}/menu/{menuId}/check")
	public ResponseEntity<?> getMenuValid(@RequestParam String companyCode, @PathVariable String menuGroupId, @PathVariable String menuId) {						
		MenuSaveDTO menu = useCase.select(companyCode, menuGroupId, menuId); 		
		Boolean isValid = menu == null ? true : false;			
		
		return toOne(isValid, String.format("%d 건 조회되었습니다.", menu != null ? 1 : 0));
	}
	
}
