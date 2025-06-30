package com.like.hrm.staff.adapter.in.web.staff.license;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.staff.license.save.StaffLicenseSaveDTO;
import com.like.hrm.staff.application.port.in.staff.license.save.StaffLicenseSaveUseCase;

@RestController
public class StaffLicenseSaveController {

	private StaffLicenseSaveUseCase useCase;
		
	public StaffLicenseSaveController(StaffLicenseSaveUseCase useCase) {
		this.useCase = useCase;
	}
		
	@PostMapping("/api/hrm/staff/{staffId}/license")
	public ResponseEntity<?> saveLicense(@Valid @RequestBody StaffLicenseSaveDTO dto) {						
				
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
	
}
