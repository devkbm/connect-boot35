package com.like.system.company.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.application.dto.CompanyInfoSaveDTO;
import com.like.system.company.application.dto.CompanyInfoSaveDTOMapstruct;
import com.like.system.company.application.port.in.CompanySelectUseCase;
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
	public CompanyInfoSaveDTO select(String companyCode) {
		CompanyInfo entity = this.dbPort.select(new CompanyInfoId(companyCode)).orElse(null);
		
		return CompanyInfoSaveDTOMapstruct.INSTANCE.toDTO(entity); 
	}

}
