package com.like.hrm.payitem.adapter.in.web.payitem;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payitem.PayItemDeleteUseCase;

@RestController
public class PayItemDeleteController {

	PayItemDeleteUseCase useCase;
	
	PayItemDeleteController(PayItemDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	@DeleteMapping("/api/hrm/payitem/{id}")
	public ResponseEntity<?> delete(@RequestParam String companyCode, @PathVariable String id) {
								
		useCase.delete(companyCode, id); 
		
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}
}
