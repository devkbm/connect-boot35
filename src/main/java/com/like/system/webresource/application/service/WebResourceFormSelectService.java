package com.like.system.webresource.application.service;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.dto.WebResourceFormSelectDTO;
import com.like.system.webresource.application.dto.WebResourceFormSelectDTOMapper;
import com.like.system.webresource.application.port.in.WebResourceFormSelectUseCase;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceFormSelectService implements WebResourceFormSelectUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceFormSelectService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public WebResourceFormSelectDTO select(String id) {
		return WebResourceFormSelectDTOMapper.toDTO(this.port.select(id));
	}

}
