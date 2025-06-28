package com.like.system.menu_role.application.service.menu_role;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.out.menu_role.MenuGroupByRolesSelectDbPort;
import com.like.system.menu_role.export.MenuGroupByUserSelectUseCase;
import com.like.system.menu_role.export.MenuGroupDTO;
import com.like.system.user.export.SystemUserDTO;
import com.like.system.user.export.SystemUserDTOSelectUseCase;

@Service
public class MenuGroupByUserSelectService implements MenuGroupByUserSelectUseCase {

	MenuGroupByRolesSelectDbPort dbPort;
	SystemUserDTOSelectUseCase userSelectUseCase;
	
	MenuGroupByUserSelectService(
			MenuGroupByRolesSelectDbPort dbPort,
			SystemUserDTOSelectUseCase userSelectUseCase
			) {
		this.dbPort = dbPort;
		this.userSelectUseCase = userSelectUseCase;
	}
		
	@Override
	public List<MenuGroupDTO> select(String userId, String companyCode) {
		SystemUserDTO userDTO = userSelectUseCase.findUser(userId, companyCode);
		
		return this.dbPort.select(companyCode, userDTO.roleList())
						  .stream()
						  .map(e -> MenuGroupDTO.toDTO(e))
						  .toList();
	}

}
