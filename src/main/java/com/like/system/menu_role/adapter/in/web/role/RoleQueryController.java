package com.like.system.menu_role.adapter.in.web.role;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.application.port.in.role.query.RoleQueryDTO;
import com.like.system.menu_role.application.port.in.role.query.RoleQueryResultDTO;
import com.like.system.menu_role.application.port.in.role.query.RoleQueryUseCase;

@RestController
public class RoleQueryController {

	private RoleQueryUseCase service;
	
	public RoleQueryController(RoleQueryUseCase service) {
		this.service = service;				
	}
	
	@GetMapping("/api/system/role")
	public ResponseEntity<?> getAuthorityList(RoleQueryDTO dto) {				
		
		List<RoleQueryResultDTO> list = service.getList(dto);								 							
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
