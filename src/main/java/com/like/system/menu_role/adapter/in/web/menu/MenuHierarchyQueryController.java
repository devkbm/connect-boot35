package com.like.system.menu_role.adapter.in.web.menu;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.menu.hierarchy.MenuHierarchyNgZorro;
import com.like.system.menu_role.application.port.in.menu.hierarchy.MenuHierarchySelectUseCase;


@Slf4j
@RestController
public class MenuHierarchyQueryController {

	private MenuHierarchySelectUseCase useCase;
	
	public MenuHierarchyQueryController(MenuHierarchySelectUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/system/menuhierarchy/{menuGroupCode}")
	public ResponseEntity<?> getMenuGroupHierachy(@RequestParam String companyCode, @PathVariable String menuGroupCode) {				
		
		log.info("companyCode : "+ companyCode);
		log.info("menuGroupCode : "+ menuGroupCode);
		List<MenuHierarchyNgZorro> menuGroup = useCase.select(companyCode, menuGroupCode); 										
		
		return toList(menuGroup, MessageUtil.getQueryMessage(menuGroup.size()));
	}

	

}
