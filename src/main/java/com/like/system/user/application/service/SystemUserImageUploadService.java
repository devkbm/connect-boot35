package com.like.system.user.application.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.user.application.port.in.SystemUserImageUploadUseCase;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.SystemUser;

@Transactional
@Service
public class SystemUserImageUploadService implements SystemUserImageUploadUseCase {

	SystemUserCommandDbPort port;
	
	SystemUserImageUploadService(SystemUserCommandDbPort port) {
		this.port = port;		
	}	

	@Override
	public String saveUploadImagePath(String companyCode, String userId, File file) throws IOException {
		SystemUser user = this.port.select(userId);
		
		if (user == null) return null;
						
		String path = file.getCanonicalPath();
		user.setImage(path);			
		
		this.port.save(user);
		
		return path;
	}

}
