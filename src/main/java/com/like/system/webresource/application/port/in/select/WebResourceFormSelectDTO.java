package com.like.system.webresource.application.port.in.select;

import lombok.Builder;

@Builder
public record WebResourceFormSelectDTO(				
		String resourceId,		
		String resourceName,
		String resourceType,		
		String url,
		String description
		) {
}
