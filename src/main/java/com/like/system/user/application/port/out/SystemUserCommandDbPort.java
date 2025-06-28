package com.like.system.user.application.port.out;

import java.util.List;
import java.util.Optional;

import com.like.system.user.domain.SystemUser;

public interface SystemUserCommandDbPort {
	
	boolean isExists(String userId);
	
	Optional<SystemUser> select(String userId);
	
	List<SystemUser> select(List<String> userIds);
	
	void save(SystemUser entity);
	
	void delete(String userId);
}
