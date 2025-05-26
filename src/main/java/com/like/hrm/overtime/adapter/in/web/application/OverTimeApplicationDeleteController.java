package com.like.hrm.overtime.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.overtime.domain.application.port.in.OverTimeApplicationDeleteUseCase;

@RestController
public class OverTimeApplicationDeleteController {

	OverTimeApplicationDeleteUseCase useCase;

	OverTimeApplicationDeleteController(OverTimeApplicationDeleteUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@DeleteMapping("/api/hrm/ovtmapplication/{id}")
	public ResponseEntity<?> deleteDutyApplication(@PathVariable Long id) {				
																		
		useCase.delete(id);						
								 					
		return toList(null, MessageUtil.getDeleteMessage(1));
	}	
}
