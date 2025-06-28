package com.like.system.menu_role.adapter.in.web.role;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.role.select.RoleSelectDTO;
import com.like.system.menu_role.application.port.in.role.select.RoleSelectUseCase;

@RestController
public class RoleSelectController {

	private RoleSelectUseCase useCase;
	
	public RoleSelectController(RoleSelectUseCase useCase) {
		this.useCase = useCase;
	}		
	
	@GetMapping("/api/system/role/{roleId}")
	public ResponseEntity<?> getRole(@RequestParam String companyCode, @PathVariable String roleId) {			
		
		RoleSelectDTO role = useCase.select(companyCode, roleId);										
		
		return toOne(role, MessageUtil.getQueryMessage(role == null ? 0 : 1));
	}
				
	
	
}
