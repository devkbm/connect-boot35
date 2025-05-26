package com.like.system.user.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserCompanyRepository;
import com.like.system.user.application.port.out.SystemUserCompanyCommandDbPort;
import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyId;

@Repository
public class SystemUserCompanyCommandDbAdapter implements SystemUserCompanyCommandDbPort {

	SystemUserCompanyRepository repository;
	
	SystemUserCompanyCommandDbAdapter(SystemUserCompanyRepository repository) {
		this.repository = repository;			
	}
	
	@Override
	public Optional<SystemUserCompany> find(SystemUserCompanyId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(SystemUserCompany entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(SystemUserCompanyId id) {
		this.repository.deleteById(id);		
	}

}
