package com.like.system.user.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.export.MenuHierarchyByRolesSelectUseCase;
import com.like.system.menu_role.export.MenuHierarchyNgZorroDTO;
import com.like.system.user.application.port.in.menu.SystemUserMenuHierarchyQueryUseCase;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.SystemUser;

@Service
public class SystemUserMenuHierarchyQueryService implements SystemUserMenuHierarchyQueryUseCase {
	
	SystemUserCommandDbPort dbPort;
	MenuHierarchyByRolesSelectUseCase menuHierarchySelectUseCase;	
	
	SystemUserMenuHierarchyQueryService(
			SystemUserCommandDbPort dbPort,
			MenuHierarchyByRolesSelectUseCase menuHierarchySelectUseCase
			) {
		this.dbPort = dbPort;
		this.menuHierarchySelectUseCase = menuHierarchySelectUseCase;		
	}
		
	@Override
	public List<MenuHierarchyNgZorroDTO> select(String companyCode, String userId, String menuGroupCode) {
		SystemUser userDTO = dbPort.select(userId).orElse(null);

		List<String> roleList = userDTO.getRoleList(companyCode).stream().map(e -> e.getRoleCode()).toList();
		
		return this.menuHierarchySelectUseCase.select(companyCode, menuGroupCode, roleList);
	}

}
