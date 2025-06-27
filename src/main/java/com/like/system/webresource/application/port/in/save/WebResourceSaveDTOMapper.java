package com.like.system.webresource.application.port.in.save;

import com.like.system.webresource.domain.WebResource;

public class WebResourceSaveDTOMapper {

	public static WebResourceSaveDTO toDTO(WebResource entity) {								
		return WebResourceSaveDTO
					.builder()
				    .createdDt(entity.getCreatedDt())	
				    .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
				    .modifiedDt(entity.getModifiedDt())
				    .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())
				    .resourceId(entity.getId())
				    .resourceName(entity.getName())
				    .resourceType(entity.getType())
				    .url(entity.getUrl())
				    .description(entity.getDescription())
				    .build();
	}
	
	
	public static WebResource toEntity(WebResourceSaveDTO dto) {
		WebResource entity = WebResource.builder()
										.resourceId(dto.resourceId())
										.resourceName(dto.resourceName())
										.resourceType(dto.resourceType())
										.url(dto.url())
										.description(dto.description())
										.build();	
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;	
	}	
}
