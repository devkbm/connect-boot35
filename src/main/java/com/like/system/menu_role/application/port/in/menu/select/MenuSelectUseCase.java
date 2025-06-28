package com.like.system.menu_role.application.port.in.menu.select;

public interface MenuSelectUseCase {
	MenuSelectDTO select(String companyCode, String menuGroupCode, String menuCode);	
}
