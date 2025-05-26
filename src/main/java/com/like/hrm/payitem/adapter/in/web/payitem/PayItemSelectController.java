package com.like.hrm.payitem.adapter.in.web.payitem;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.dto.payitem.PayItemFormDTO;
import com.like.hrm.payitem.application.port.in.payitem.PayItemSelectUseCase;

@RestController
public class PayItemSelectController {

	PayItemSelectUseCase useCase;
	
	PayItemSelectController(PayItemSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/payitem/{id}")
	public ResponseEntity<?> select(@RequestParam String companyCode, @PathVariable String id) {
								
		PayItemFormDTO dto = useCase.select(companyCode, id); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
	
}
