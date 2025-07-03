package com.like.hrm.staff.adapter.in.web.staff;

import static com.like.core.web.util.ResponseEntityUtil.toList;
import static com.like.core.web.util.ResponseEntityUtil.toOne;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.staff.query.StaffCurrentAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.query.StaffQueryUseCase;

@RestController
public class StaffQueryController {
	
	StaffQueryUseCase useCase;
	
	StaffQueryController(StaffQueryUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/hrm/staff")
	public ResponseEntity<?> getStaffList(StaffQueryDTO dto) {
									
		List<StaffQueryResultDTO> list = useCase.getStaffList(dto); 
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	/*
	@GetMapping("/api/hrm/staff/{id}/record")
	public ResponseEntity<?> getStaffAppointmentRecordList(@RequestParam String companyCode, @PathVariable String id) {
		
		List<?> list = service.getStaffAppointmentRecordList(companyCode, id);								
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	*/
	
	@GetMapping("/api/hrm/staff/{id}/currentappointment")
	public ResponseEntity<?> getStaffCurrentAppointment(@RequestParam String companyCode, @PathVariable String id) {
		
		StaffCurrentAppointmentQueryResultDTO dto = useCase.getStaffCurrentAppointment(companyCode, id);								
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
}
