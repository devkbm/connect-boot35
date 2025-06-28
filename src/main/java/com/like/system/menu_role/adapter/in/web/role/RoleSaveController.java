package com.like.system.menu_role.adapter.in.web.role;

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
import com.like.system.menu_role.application.port.in.role.save.RoleSaveDTO;
import com.like.system.menu_role.application.port.in.role.save.RoleSaveUseCase;

@RestController
public class RoleSaveController {

	RoleSaveUseCase useCase;
	
	public RoleSaveController(RoleSaveUseCase useCase) {
		this.useCase= useCase;
	}
	
	@GetMapping("/api/system/role/{roleCode}/check")
	public ResponseEntity<?> dupCheck(@RequestParam String companyCode,@PathVariable String roleCode) {			
					
		boolean exist = useCase.exists(companyCode, roleCode);													
						
		return toOne(exist, exist == true? "기존에 등록된 권한이 존재합니다." : "신규 등록 가능합니다.");
	}
	
	@PostMapping("/api/system/role")
	public ResponseEntity<?> save(@RequestBody RoleSaveDTO dto) {			
		
		useCase.save(dto);					
																				 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
	
}
