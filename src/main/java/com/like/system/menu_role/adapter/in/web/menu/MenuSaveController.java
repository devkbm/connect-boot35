package com.like.system.menu_role.adapter.in.web.menu;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;
import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.menu.save.MenuSaveDTO;
import com.like.system.menu_role.application.port.in.menu.save.MenuSaveUseCase;

@RestController
public class MenuSaveController {
	
	private MenuSaveUseCase useCase;		
			
	public MenuSaveController(MenuSaveUseCase useCase) {
		this.useCase = useCase;		
	}						
	
	@GetMapping("/api/system/menugroup/{menuGroupId}/menu/{menuId}/check")
	public ResponseEntity<?> getMenuValid(@RequestParam String companyCode, @PathVariable String menuGroupId, @PathVariable String menuId) {								
		Boolean exist = useCase.exist(companyCode, menuGroupId, menuId);			
		
		return toOne(exist, exist ? "중복된 메뉴코드가 존재합니다" : "사용 가능한 메뉴코드입니다.");
	}
		
	@PostMapping("/api/system/menugroup/{menuGroupCode}/menu/{menuCode}")
	public ResponseEntity<?> saveMenu(@RequestBody @Valid MenuSaveDTO dto) throws Exception {												
									
		useCase.save(dto);																			
														 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}		
}
