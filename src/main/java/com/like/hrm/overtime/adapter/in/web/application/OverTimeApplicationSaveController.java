package com.like.hrm.overtime.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.overtime.domain.application.port.in.OverTimeApplicationSaveUseCase;
import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTO;

@RestController
public class OverTimeApplicationSaveController {

	OverTimeApplicationSaveUseCase useCase;
	
	OverTimeApplicationSaveController(OverTimeApplicationSaveUseCase useCase) {
		this.useCase = useCase;
	}

	@PostMapping("/api/hrm/ovtmapplication")
	public ResponseEntity<?> save(@RequestBody OverTimeApplicationFormDTO dto) {				
																			
		useCase.save(dto);						
								 					
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
