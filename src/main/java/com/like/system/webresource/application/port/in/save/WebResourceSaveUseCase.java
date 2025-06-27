package com.like.system.webresource.application.port.in.save;


public interface WebResourceSaveUseCase {
	void save(WebResourceSaveDTO dto);
	
	boolean exists(String id);
}
