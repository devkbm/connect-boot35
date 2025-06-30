package com.like.hrm.staff.adapter.in.web.staff.schoolcareer;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryUseCase;

@RestController
public class StaffSchoolCareerQueryController {
	
	StaffSchoolCareerQueryUseCase useCase;
	
	StaffSchoolCareerQueryController(StaffSchoolCareerQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/staff/{staffId}/schoolcareer")
	public ResponseEntity<?> getSchoolCareer(@RequestParam String companyCode, @PathVariable String staffId) {			
		List<StaffSchoolCareerQueryResultDTO> list = useCase.select(companyCode, staffId);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
