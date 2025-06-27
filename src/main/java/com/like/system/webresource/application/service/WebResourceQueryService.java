package com.like.system.webresource.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.port.in.query.WebResourceQueryDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryResultDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryUseCase;
import com.like.system.webresource.application.port.out.WebResourceQueryDbPort;

@Service
public class WebResourceQueryService implements WebResourceQueryUseCase {

	private WebResourceQueryDbPort port;
	
	public WebResourceQueryService(WebResourceQueryDbPort port) {
		this.port = port;		
	}	

	@Override
	public List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto) {	
		return this.port.getResourceList(dto);
	}
}
