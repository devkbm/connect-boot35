package com.like.hrm.hrmcode.adapter.in.web.hrmcode;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.hrm.hrmcode.application.port.in.hrmcode.HrmCodeSelectUseCase;

@RestController
public class HrmCodeValidController {
	
	HrmCodeSelectUseCase useCase;
		
	public HrmCodeValidController(HrmCodeSelectUseCase useCase) {
		this.useCase = useCase;		
	}
		
	@GetMapping("/api/hrm/hrmtype/{type}/code/{code}/valid")
	public ResponseEntity<?> validHrmCode(@PathVariable String type, @PathVariable String code) {
		
		boolean isDuplicated = useCase.select(type, code) == null ? false : true;
					
		return toOne(isDuplicated ? false : true, isDuplicated ? "중복된 인사유형 코드가 있습니다." : "사용가능한 코드입니다.");
	}
	
}
