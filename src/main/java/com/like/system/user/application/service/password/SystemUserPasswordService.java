package com.like.system.user.application.service.password;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.like.system.user.application.port.in.password.SystemUserPasswordChangeDTO;
import com.like.system.user.application.port.in.password.SystemUserPasswordChangeUseCase;
import com.like.system.user.application.port.in.password.SystemUserPasswordInitUseCase;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserPassword;

@Transactional
@Service
public class SystemUserPasswordService implements SystemUserPasswordChangeUseCase, SystemUserPasswordInitUseCase {

	SystemUserCommandDbPort dbPort;
	PasswordEncoder passwordEncoder;
	
	SystemUserPasswordService(
			SystemUserCommandDbPort dbPort,
			PasswordEncoder passwordEncoder
			) {
		this.dbPort = dbPort;		
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void initPassword(String companyCode, String userId) {
		SystemUser user = dbPort.select(userId).orElse(null);
		
		user.setPassword(passwordEncoder, SystemUserPassword.getInitPassword());		
		
		dbPort.save(user);
	}
	
	@Override
	public void changePassword(SystemUserPasswordChangeDTO dto) {
		SystemUser user = dbPort.select(dto.userId()).orElse(null);			
				
		user.changePassword(passwordEncoder, dto.beforePassword(), dto.afterPassword());		 	
		
		dbPort.save(user);
	}
}
