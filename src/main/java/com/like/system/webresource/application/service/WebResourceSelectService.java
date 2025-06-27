package com.like.system.webresource.application.service;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.port.in.select.WebResourceFormSelectDTO;
import com.like.system.webresource.application.port.in.select.WebResourceFormSelectDTOMapper;
import com.like.system.webresource.application.port.in.select.WebResourceFormSelectUseCase;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceSelectService implements WebResourceFormSelectUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceSelectService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public WebResourceFormSelectDTO select(String id) {
		return WebResourceFormSelectDTOMapper.toDTO(this.port.select(id).orElse(null));
	}

}
