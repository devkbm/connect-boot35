package com.like.system.user.application.port.out;

import java.util.List;

import com.like.system.user.domain.SystemUser;

public interface SystemUserCommandDbPort {
	SystemUser select(String userId);
	
	List<SystemUser> select(List<String> userIds);
	
	void save(SystemUser entity);
	
	void delete(String userId);
}
