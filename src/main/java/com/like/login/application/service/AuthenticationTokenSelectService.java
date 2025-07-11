package com.like.login.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.export.MenuGroupByUserSelectUseCase;
import com.like.system.menu_role.export.MenuGroupDTO;
import com.like.system.user.export.SystemUserDTO;
import com.like.system.user.export.SystemUserDTOSelectUseCase;

import lombok.extern.slf4j.Slf4j;

import com.like.login.application.port.in.AuthenticationToken;
import com.like.login.application.port.in.AuthenticationTokenSelectUseCase;

@Slf4j
@Transactional
@Service
public class AuthenticationTokenSelectService implements AuthenticationTokenSelectUseCase {

	SystemUserDTOSelectUseCase userSelectUseCase;
	MenuGroupByUserSelectUseCase menuGroupSelectUseCase;
	
	AuthenticationTokenSelectService(
			SystemUserDTOSelectUseCase userSelectUseCase,
			MenuGroupByUserSelectUseCase menuGroupSelectUseCase
			) {
		this.userSelectUseCase = userSelectUseCase;
		this.menuGroupSelectUseCase = menuGroupSelectUseCase;
	}
	
	@Override
	public AuthenticationToken select(String userId, String companyCode, String sessionId, String ipAddress) {
		SystemUserDTO user = userSelectUseCase.findUser(userId, companyCode);
		
		log.info(user.toString());
		
		List<MenuGroupDTO> menuGroupList = menuGroupSelectUseCase.select(user.userId(), companyCode);
		
		return AuthenticationToken.of(user, menuGroupList, ipAddress, sessionId);
	}

}
