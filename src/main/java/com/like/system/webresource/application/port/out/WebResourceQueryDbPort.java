package com.like.system.webresource.application.port.out;

import java.util.List;

import com.like.system.webresource.application.dto.WebResourceQueryDTO;
import com.like.system.webresource.application.dto.WebResourceQueryResultDTO;

public interface WebResourceQueryDbPort {
	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto);
}
