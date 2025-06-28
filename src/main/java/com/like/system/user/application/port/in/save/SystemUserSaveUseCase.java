package com.like.system.user.application.port.in.save;

public interface SystemUserSaveUseCase {
	
	boolean exists(String userId); 
		
	void save(SystemUserSaveDTO dto);	
}
