package com.like.system.webresource.adapter.in.web;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.webresource.application.port.in.save.WebResourceSaveUseCase;
import com.like.system.webresource.application.port.in.save.WebResourceSaveDTO;

@RestController
public class WebResourceSaveController {

	private WebResourceSaveUseCase useCase;
	
	public WebResourceSaveController(WebResourceSaveUseCase useCase) {
		this.useCase = useCase;		
	}
		
		
	@PostMapping("/api/system/webresource")
	public ResponseEntity<?> save(@RequestBody @Valid WebResourceSaveDTO dto) throws Exception {
																												
		useCase.save(dto);																						
										 					
		return toOne(null, String.format("%d 건 저장되었습니다.", 1));
	}	
}
