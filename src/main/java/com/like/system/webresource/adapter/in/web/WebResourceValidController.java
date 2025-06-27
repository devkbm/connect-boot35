package com.like.system.webresource.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.webresource.application.port.in.select.WebResourceFormSelectDTO;
import com.like.system.webresource.application.port.in.select.WebResourceFormSelectUseCase;

@RestController
public class WebResourceValidController {

	private WebResourceFormSelectUseCase service;
	
	public WebResourceValidController(WebResourceFormSelectUseCase service) {
		this.service = service;
	}
	
	@GetMapping("/api/system/webresource/{id}/check")
	public ResponseEntity<?> getResource(@PathVariable String id) {						
		WebResourceFormSelectDTO resource = service.select(id); 							
		Boolean isValid = resource == null ? true : false;
						
		return toOne(isValid, isValid == true ? "사용가능한 리소스 코드입니다." : "중복된 리소스 코드가 있습니다.");
	}
	
}
