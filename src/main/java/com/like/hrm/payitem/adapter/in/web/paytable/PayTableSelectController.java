package com.like.hrm.payitem.adapter.in.web.paytable;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.dto.paytable.PayTableFormDTO;
import com.like.hrm.payitem.application.port.in.paytable.PayTableSelectUseCase;

@RestController
public class PayTableSelectController {

	PayTableSelectUseCase useCase;
	
	PayTableSelectController(PayTableSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/paytable/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {
								
		PayTableFormDTO dto = useCase.select(id); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
}
