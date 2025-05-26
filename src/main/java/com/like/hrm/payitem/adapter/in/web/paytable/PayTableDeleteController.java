package com.like.hrm.payitem.adapter.in.web.paytable;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.paytable.PayTableDeleteUseCase;

@RestController
public class PayTableDeleteController {

	PayTableDeleteUseCase useCase;
	
	PayTableDeleteController(PayTableDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	
	@DeleteMapping("/api/hrm/paytable/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
								
		useCase.delete(id); 
		
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}
}
