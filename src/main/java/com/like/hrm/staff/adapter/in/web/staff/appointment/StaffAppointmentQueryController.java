package com.like.hrm.staff.adapter.in.web.staff.appointment;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryUseCase;

@RestController
public class StaffAppointmentQueryController {

	StaffAppointmentQueryUseCase useCase;
	
	public StaffAppointmentQueryController(StaffAppointmentQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/staff/{staffId}/record")
	public ResponseEntity<?> getAppointmentRecordList(@RequestParam String companyCode, @PathVariable String staffId) {
										
		List<StaffAppointmentQueryResultDTO> list = useCase.select(companyCode, staffId); 		
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
