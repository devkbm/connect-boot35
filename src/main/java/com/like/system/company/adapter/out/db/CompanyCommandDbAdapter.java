package com.like.system.company.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.company.adapter.out.db.data.CompanyJpaRepository;
import com.like.system.company.application.port.out.CompanyCommandDbPort;
import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;

@Repository
public class CompanyCommandDbAdapter implements CompanyCommandDbPort {

	CompanyJpaRepository repository;
	
	CompanyCommandDbAdapter(CompanyJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean exists(CompanyInfoId companyId) {
		return this.repository.existsById(companyId);
	}
	
	@Override
	public Optional<CompanyInfo> select(CompanyInfoId companyId) {
		return this.repository.findById(companyId);
	}

	@Override
	public void save(CompanyInfo entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(CompanyInfoId companyId) {
		this.repository.deleteById(companyId);		
	}

	

}
