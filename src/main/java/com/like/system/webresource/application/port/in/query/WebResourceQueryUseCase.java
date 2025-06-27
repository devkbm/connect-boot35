package com.like.system.webresource.application.port.in.query;

import java.util.List;

public interface WebResourceQueryUseCase {

	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO condition);
}
