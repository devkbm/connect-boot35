package com.like.hrm.staff.adapter.in.web.partner;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTO;
import com.like.hrm.staff.application.port.in.partner.PartnerCompanyStaffSaveUseCase;

@RestController
public class PartnerCompanyStaffSaveController {
	
	private PartnerCompanyStaffSaveUseCase useCase;
		
	public PartnerCompanyStaffSaveController(PartnerCompanyStaffSaveUseCase useCase) {
		this.useCase = useCase;
	}		
			
	@PostMapping("/api/hrm/partnerstaff")
	public ResponseEntity<?> save(@RequestBody @Valid PartnerCompanyStaffFormDTO dto) {			
														
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}	
			
}
