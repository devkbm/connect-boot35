package com.like.system.user.application.port.out;

import java.util.Optional;

import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyId;

public interface SystemUserCompanyCommandDbPort {
	
	Optional<SystemUserCompany> find(SystemUserCompanyId id); 
	
	void save(SystemUserCompany entity);
	
	void delete(SystemUserCompanyId id);
}
