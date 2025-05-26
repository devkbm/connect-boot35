package com.like.system.company.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.company.application.dto.CompanyInfoSaveDTO;
import com.like.system.company.application.port.in.CompanyQueryUseCase;

@RestController
public class CompanyQueryController {

	CompanyQueryUseCase useCase;
	
	CompanyQueryController(CompanyQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/company")
	public ResponseEntity<?> getList() {
							
		List<CompanyInfoSaveDTO> list = useCase.query();  						 						
		
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
}
