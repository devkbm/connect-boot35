package com.like.system.company.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.application.port.in.CompanyDeleteUseCase;
import com.like.system.company.application.port.out.CompanyCommandDbPort;
import com.like.system.company.domain.CompanyInfoId;

@Transactional
@Service
public class CompanyDeleteService implements CompanyDeleteUseCase {

	CompanyCommandDbPort dbPort;
	
	CompanyDeleteService(CompanyCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}	
	
	@Override
	public void delete(String companyCode) {
		this.dbPort.delete(new CompanyInfoId(companyCode));
	}

}
