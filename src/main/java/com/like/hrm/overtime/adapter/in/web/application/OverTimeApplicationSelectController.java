package com.like.hrm.overtime.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.overtime.domain.application.port.in.OverTimeApplicationSelectUseCase;
import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTO;

@RestController
public class OverTimeApplicationSelectController {
	
	OverTimeApplicationSelectUseCase useCase;
	
	OverTimeApplicationSelectController(OverTimeApplicationSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/ovtmapplication/{id}")
	public ResponseEntity<?> select(@PathVariable Long id) {
											
		OverTimeApplicationFormDTO dto = useCase.select(id);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
}
