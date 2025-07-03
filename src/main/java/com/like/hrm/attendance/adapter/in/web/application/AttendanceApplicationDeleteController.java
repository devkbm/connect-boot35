package com.like.hrm.attendance.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.attendance.application.port.in.application.delete.AttendanceApplcationFormDeleteUseCase;

@RestController
public class AttendanceApplicationDeleteController {
	
	AttendanceApplcationFormDeleteUseCase useCase;
	
	AttendanceApplicationDeleteController(AttendanceApplcationFormDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	@DeleteMapping("/api/hrm/dutyapplication/{id}")
	public ResponseEntity<?> deleteDutyApplication(@PathVariable Long id) {				
																		
		useCase.delete(id);						
								 					
		return toList(null, MessageUtil.getDeleteMessage(1));
	}	
}
