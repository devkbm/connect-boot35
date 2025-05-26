package com.like.hrm.payitem.adapter.in.web.payitem;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.dto.payitem.PayItemFormDTO;
import com.like.hrm.payitem.application.port.in.payitem.PayItemSaveUseCase;

import jakarta.validation.Valid;

@RestController
public class PayItemSaveController {

	PayItemSaveUseCase useCase;
	
	PayItemSaveController(PayItemSaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/payitem")
	public ResponseEntity<?> save(@RequestBody @Valid PayItemFormDTO dto) {			
														
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
