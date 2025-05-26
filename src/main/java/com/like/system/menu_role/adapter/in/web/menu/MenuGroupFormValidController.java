package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;
import com.like.system.menu_role.application.port.in.menu.MenuGroupSelectUseCase;

@RestController
public class MenuGroupFormValidController {

	private MenuGroupSelectUseCase useCase;
	
	public MenuGroupFormValidController(MenuGroupSelectUseCase useCase) {
		this.useCase = useCase;		
	}

	@GetMapping("/api/system/menugroup/{menuGroupId}/check")
	public ResponseEntity<?> getMenuGroupValid(@RequestParam String companyCode, @PathVariable String menuGroupId) {							
		MenuGroupSaveDTO menuGroup = useCase.select(companyCode, menuGroupId);
		Boolean isValid = menuGroup == null ? true : false;				
								
		return toOne(isValid, String.format("%d 건 조회되었습니다.", menuGroup != null ? 1 : 0));
	}	
	
}
