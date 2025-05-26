package com.like.hrm.staff.adapter.in.web.partner;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTO;
import com.like.hrm.staff.application.port.in.partner.PartnerCompanyStaffSelectUseCase;

@RestController
public class PartnerCompanyStaffSelectController {
	
	PartnerCompanyStaffSelectUseCase useCase;
		
	PartnerCompanyStaffSelectController(PartnerCompanyStaffSelectUseCase useCase) {
		this.useCase = useCase;
	}		
	
	@GetMapping("/api/hrm/partnerstaff/{id}")
	public ResponseEntity<?> select(@RequestParam String companyCode, @PathVariable String id) {
								
		PartnerCompanyStaffFormDTO dto = useCase.select(companyCode, id); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}		
			
}
