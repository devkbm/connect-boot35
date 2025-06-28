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
import com.like.system.menu_role.application.port.in.menu.save.MenuGroupSaveDTO;
import com.like.system.menu_role.application.port.in.menu.save.MenuGroupSaveUseCase;

@RestController
public class MenuGroupSaveController {
	
	private MenuGroupSaveUseCase useCase;		
			
	public MenuGroupSaveController(MenuGroupSaveUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/system/menugroup/{menuGroupId}/check")
	public ResponseEntity<?> getMenuGroupValid(@RequestParam String companyCode, @PathVariable String menuGroupId) {									
		Boolean exist = useCase.exist(companyCode, menuGroupId);				
								
		return toOne(exist, exist ? "중복된 메뉴그룹코드가 존재합니다." : "사용 가능한 메뉴그룹코드입니다");
	}	
		
	@PostMapping("/api/system/menugroup/{id}")
	public ResponseEntity<?> saveMenuGroup(@Valid @RequestBody MenuGroupSaveDTO dto) {							
																			
		useCase.save(dto);			
										 					
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
