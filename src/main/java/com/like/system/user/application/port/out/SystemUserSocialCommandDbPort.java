package com.like.system.user.application.port.out;

import java.util.Optional;

import com.like.system.user.domain.oauth2.SystemUserSocial;
import com.like.system.user.domain.oauth2.SystemUserSocialId;

public interface SystemUserSocialCommandDbPort {

	Optional<SystemUserSocial> select(SystemUserSocialId id);
	
	void save(SystemUserSocial entity);
	
	void delete(SystemUserSocialId id);
	
}
