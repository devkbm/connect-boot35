package com.like.system.webresource.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.webresource.adapter.out.db.querydsl.WebResourceQuerydsl;
import com.like.system.webresource.application.port.in.query.WebResourceQueryDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryResultDTO;
import com.like.system.webresource.application.port.out.WebResourceQueryDbPort;

@Repository
@Transactional(readOnly = true)
public class WebResourceQueryDbAdapter implements WebResourceQueryDbPort {	
	
	WebResourceQuerydsl query;
	
	public WebResourceQueryDbAdapter(WebResourceQuerydsl query) {
		this.query = query;
	}	

	@Override
	public List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto) {
		return this.query.getList(dto);
	}	

	
}
