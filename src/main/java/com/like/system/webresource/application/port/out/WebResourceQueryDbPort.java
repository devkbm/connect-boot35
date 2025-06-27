package com.like.system.webresource.application.port.out;

import java.util.List;

import com.like.system.webresource.application.port.in.query.WebResourceQueryDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryResultDTO;

public interface WebResourceQueryDbPort {
	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto);
}
