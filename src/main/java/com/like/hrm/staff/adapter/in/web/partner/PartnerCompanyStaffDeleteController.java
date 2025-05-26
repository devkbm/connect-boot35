package com.like.hrm.staff.adapter.in.web.partner;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.partner.PartnerCompanyStaffDeleteUseCase;

@RestController
public class PartnerCompanyStaffDeleteController {
	
	PartnerCompanyStaffDeleteUseCase useCase;
		
	PartnerCompanyStaffDeleteController(PartnerCompanyStaffDeleteUseCase useCase) {
		this.useCase = useCase;
	}		
	
	@DeleteMapping("/api/hrm/partnerstaff/{id}")
	public ResponseEntity<?> delete(@RequestParam String companyCode, @PathVariable String id) {
								
		useCase.delete(companyCode, id); 
		
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}		
			
}
