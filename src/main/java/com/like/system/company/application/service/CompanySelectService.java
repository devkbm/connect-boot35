package com.like.system.company.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.application.port.in.select.CompanySelectDTO;
import com.like.system.company.application.port.in.select.CompanySelectDTOMapstruct;
import com.like.system.company.application.port.in.select.CompanySelectUseCase;
import com.like.system.company.application.port.out.CompanyCommandDbPort;
import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;

@Transactional
@Service
public class CompanySelectService implements CompanySelectUseCase {

	CompanyCommandDbPort dbPort;
	
	CompanySelectService(CompanyCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public CompanySelectDTO select(String companyCode) {
		CompanyInfo entity = this.dbPort.select(new CompanyInfoId(companyCode)).orElse(null);
		
		return CompanySelectDTOMapstruct.INSTANCE.toDTO(entity); 
	}

}
