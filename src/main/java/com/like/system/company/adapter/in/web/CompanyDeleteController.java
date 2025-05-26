package com.like.system.company.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.company.application.port.in.CompanyDeleteUseCase;

@RestController
public class CompanyDeleteController {

	CompanyDeleteUseCase useCase;
	
	CompanyDeleteController(CompanyDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	@DeleteMapping("/api/system/company/{companyCode}")
	public ResponseEntity<?> deleteCompany(@PathVariable String companyCode) {				
												
		useCase.delete(companyCode);							
		
		return toList(null, MessageUtil.getDeleteMessage(1));
	}
}
