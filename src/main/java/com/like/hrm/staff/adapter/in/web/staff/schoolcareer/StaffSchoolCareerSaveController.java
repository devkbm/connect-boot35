package com.like.hrm.staff.adapter.in.web.staff.schoolcareer;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.dto.staff.schoolcareer.StaffSchoolCareerFormDTO;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.StaffSchoolCareerSaveUseCase;

@RestController
public class StaffSchoolCareerSaveController {

	private StaffSchoolCareerSaveUseCase useCase;
		
	public StaffSchoolCareerSaveController(StaffSchoolCareerSaveUseCase useCase) {
		this.useCase = useCase;
	}
		
	@PostMapping("/api/hrm/staff/{staffId}/schoolcareer")
	public ResponseEntity<?> saveSchoolCareer(@RequestBody @Valid StaffSchoolCareerFormDTO dto) {
		useCase.save(dto);
											 				
		return toOne(null, MessageUtil.getSaveMessage(1));
	}
	
}
