package com.like.system.webresource.application.port.in;

import com.like.system.webresource.application.dto.WebResourceFormSelectDTO;

public interface WebResourceFormSelectUseCase {

	WebResourceFormSelectDTO select(String webResourceId);
}
