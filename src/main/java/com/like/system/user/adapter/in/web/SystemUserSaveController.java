package com.like.system.user.adapter.in.web;

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
import com.like.system.user.application.port.in.save.SystemUserSaveDTO;
import com.like.system.user.application.port.in.save.SystemUserSaveUseCase;

@RestController
public class SystemUserSaveController {		
					
	SystemUserSaveUseCase useCase;
		
	public SystemUserSaveController(SystemUserSaveUseCase userCase) {		
		this.useCase = userCase;
	}		
	
	@PostMapping("/api/system/user")	
	public ResponseEntity<?> saveUser(@Valid @RequestBody SystemUserSaveDTO dto) {			
											
		useCase.save(dto);					
																					 		
		return toList(null, MessageUtil.getSaveMessage(1));
	}
		
	@GetMapping("/api/system/user/{userId}/check")
	public ResponseEntity<?> checkId(@RequestParam String companyCode, @PathVariable String userId) {
						
		boolean isDuplicated = useCase.exists(userId);					
				
		return toOne(isDuplicated, isDuplicated ? "기존 아이디가 존재합니다." : "신규 등록 가능합니다."); 
	}	
	
}