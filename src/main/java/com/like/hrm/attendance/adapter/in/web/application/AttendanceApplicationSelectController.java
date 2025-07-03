package com.like.hrm.attendance.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveDTO;
import com.like.hrm.attendance.application.port.in.application.select.AttendanceApplicationSelectUseCase;

@RestController
public class AttendanceApplicationSelectController {

	AttendanceApplicationSelectUseCase useCase;
	
	AttendanceApplicationSelectController(AttendanceApplicationSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/dutyapplication/{id}")
	public ResponseEntity<?> getDutyApplication(@PathVariable Long id) {
											
		AttendanceApplicationSaveDTO dto = useCase.select(id);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
}
