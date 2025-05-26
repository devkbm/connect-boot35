package com.like.system.webresource.application.service;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.dto.WebResourceSaveDTO;
import com.like.system.webresource.application.dto.WebResourceSaveDTOMapper;
import com.like.system.webresource.application.port.in.WebResourceFormSaveUseCase;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceFormSaveService implements WebResourceFormSaveUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceFormSaveService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(WebResourceSaveDTO dto) {
		this.port.save(WebResourceSaveDTOMapper.toEntity(dto));		
	}
}
