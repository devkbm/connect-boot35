package com.like.system.company.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.application.port.in.save.CompanySaveDTO;
import com.like.system.company.application.port.in.save.CompanySaveDTOMapstruct;
import com.like.system.company.application.port.in.save.CompanySaveUseCase;
import com.like.system.company.application.port.out.CompanyCommandDbPort;
import com.like.system.company.domain.CompanyInfo;

@Transactional
@Service
public class CompanySaveService implements CompanySaveUseCase {

	CompanyCommandDbPort dbPort;
	
	CompanySaveService(CompanyCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(CompanySaveDTO dto) {
		//CompanyInfo entity = CompanyInfoSaveDTOMapper.toEntity(dto);
		CompanyInfo entity = CompanySaveDTOMapstruct.INSTANCE.toEntity(dto);
		
		this.dbPort.save(entity);
	}

}
