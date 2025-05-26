package com.like.system.menu_role.adapter.in.web.role;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.dto.role.RoleSaveDTO;
import com.like.system.menu_role.application.port.in.role.RoleSaveUseCase;

@RestController
public class RoleSaveController {

	RoleSaveUseCase useCase;
	
	public RoleSaveController(RoleSaveUseCase useCase) {
		this.useCase= useCase;
	}
	
	@PostMapping("/api/system/role")
	public ResponseEntity<?> saveAuthority(@RequestBody RoleSaveDTO dto) {			
		
		useCase.save(dto);					
																				 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
