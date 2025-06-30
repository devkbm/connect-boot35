package com.like.hrm.staff.adapter.in.web.staff.dutyresponsibility;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryUseCase;

@RestController
public class StaffDutyResponsibilityQueryController {

	StaffDutyResponsibilityQueryUseCase useCase;
	
	public StaffDutyResponsibilityQueryController(StaffDutyResponsibilityQueryUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/hrm/staff/{staffId}/dutyresponsibility")
	public ResponseEntity<?> getList(@RequestParam String companyCode, @PathVariable String staffId) {
				
		List<StaffDutyResponsibilityQueryResultDTO> list = this.useCase.select(companyCode, staffId);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
