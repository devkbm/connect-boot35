package com.like.hrm.staff.adapter.in.web.staff.dutyresponsibility;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.dto.staff.dutyresponsibility.StaffDutyResponsibilityFormDTO;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.StaffDutyResponsibilitySaveUseCase;

@RestController
public class StaffDutyResponsibilitySaveController {

	private StaffDutyResponsibilitySaveUseCase useCase;
	
	public StaffDutyResponsibilitySaveController(StaffDutyResponsibilitySaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/staff/{staffId}/dutyresponsibility")
	public ResponseEntity<?> save(@Valid @RequestBody StaffDutyResponsibilityFormDTO dto) {			
									
		useCase.save(dto);
		
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
