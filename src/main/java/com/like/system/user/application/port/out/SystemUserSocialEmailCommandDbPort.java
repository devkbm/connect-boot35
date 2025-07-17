package com.like.system.user.application.port.out;

import java.util.Optional;

import com.like.system.user.domain.oauth2.SystemUserSocialEmail;
import com.like.system.user.domain.oauth2.SystemUserSocialEmailId;

public interface SystemUserSocialEmailCommandDbPort {

	Optional<SystemUserSocialEmail> select(SystemUserSocialEmailId id);
	
	void save(SystemUserSocialEmail entity);
	
	void delete(SystemUserSocialEmailId id);
	
}
