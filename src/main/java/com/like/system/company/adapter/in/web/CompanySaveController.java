package com.like.system.company.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.company.application.port.in.save.CompanySaveDTO;
import com.like.system.company.application.port.in.save.CompanySaveUseCase;

import jakarta.validation.Valid;

@RestController
public class CompanySaveController {
	
	CompanySaveUseCase useCase;
	
	CompanySaveController(CompanySaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/system/company")
	public ResponseEntity<?> saveCompany(@Valid @RequestBody CompanySaveDTO dto) {			
																
		useCase.save(dto);		
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}			
	
}
