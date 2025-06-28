package com.like.system.menu_role.application.port.in.menu.query;

import com.like.system.menu_role.domain.menu.MenuGroup;

public class MenuGroupQueryResultDTOMapper {

	public static MenuGroupQueryResultDTO toDTO(MenuGroup entity) {
		if (entity == null) return null;
		
		return MenuGroupQueryResultDTO.builder()
							.createdDt(entity.getCreatedDt())
							.createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
							.modifiedDt(entity.getModifiedDt())
							.modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())								
							.companyCode(entity.getId().getCompanyCode())
							//.menuGroupId(entity.getId())
							.menuGroupCode(entity.getId().getMenuGroupCode())
							.menuGroupName(entity.getName())
							.menuGroupUrl(entity.getMenuGroupUrl())
							.description(entity.getDescription())
							.sequence(entity.getSequence())
							.build();
	}
		
}
