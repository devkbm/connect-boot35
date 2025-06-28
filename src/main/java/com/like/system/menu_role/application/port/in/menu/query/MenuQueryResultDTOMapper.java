package com.like.system.menu_role.application.port.in.menu.query;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuAppIcon;

public class MenuQueryResultDTOMapper {

	public static MenuQueryResultDTO toDTO(Menu entity) {
		
		Optional<MenuAppIcon> menuAppIcon = Optional.ofNullable(entity.getAppIcon());
		
		return MenuQueryResultDTO.builder()
				   	   .createdDt(entity.getCreatedDt())
				   	   .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
				   	   .modifiedDt(entity.getModifiedDt())
				   	   .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())					   	   
				   	   .companyCode(entity.getMenuGroup().getId().getCompanyCode())
				   	   .menuGroupCode(entity.getMenuGroup().getId().getMenuGroupCode())					   	   					   	   
				   	   .menuCode(entity.getId().getMenuCode())
				   	   .menuName(entity.getName())
				   	   .menuType(entity.getType().toString())
				   	   .appUrl(entity.getAppUrl())
				   	   .appIconType(menuAppIcon.map(MenuAppIcon::getAppIconType).orElse(""))
				   	   .appIcon(menuAppIcon.map(MenuAppIcon::getAppIcon).orElse(""))
				   	   .sequence(entity.getSequence())
				   	   .level(entity.getLevel())
				   	   .parentMenuCode(entity.getParentMenuCode())					   	   
				   	   .build();
	}
	
}
