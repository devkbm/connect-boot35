package com.like.system.webresource.application.service;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.port.in.save.WebResourceSaveUseCase;
import com.like.system.webresource.application.port.in.save.WebResourceSaveDTO;
import com.like.system.webresource.application.port.in.save.WebResourceSaveDTOMapper;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceSaveService implements WebResourceSaveUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceSaveService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(WebResourceSaveDTO dto) {
		this.port.save(WebResourceSaveDTOMapper.toEntity(dto));		
	}

	@Override
	public boolean exists(String id) {
		return this.port.exists(id);
	}
}
