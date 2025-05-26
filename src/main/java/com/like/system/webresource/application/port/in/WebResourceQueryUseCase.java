package com.like.system.webresource.application.port.in;

import java.util.List;

import com.like.system.webresource.application.dto.WebResourceQueryDTO;
import com.like.system.webresource.application.dto.WebResourceQueryResultDTO;

public interface WebResourceQueryUseCase {

	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO condition);
}
