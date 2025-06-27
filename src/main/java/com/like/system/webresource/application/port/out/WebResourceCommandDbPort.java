package com.like.system.webresource.application.port.out;

import java.util.Optional;

import com.like.system.webresource.domain.WebResource;

public interface WebResourceCommandDbPort {
	
	boolean exists(String id);
	
	Optional<WebResource> select(String id);
	
	void save(WebResource entity);
	
	void delete(String id);
}
