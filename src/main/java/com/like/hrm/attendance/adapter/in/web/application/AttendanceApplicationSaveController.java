package com.like.hrm.attendance.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.attendance.application.dto.application.AttendanceApplicationDTO;
import com.like.hrm.attendance.application.port.in.application.AttendanceApplicationFormSaveUseCase;

@RestController
public class AttendanceApplicationSaveController {

	AttendanceApplicationFormSaveUseCase useCase;
	
	AttendanceApplicationSaveController(AttendanceApplicationFormSaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/dutyapplication")
	public ResponseEntity<?> saveDutyApplication(@RequestBody AttendanceApplicationDTO dto) {				
																			
		useCase.save(dto);						
								 					
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
