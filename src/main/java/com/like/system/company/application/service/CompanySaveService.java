package com.like.system.company.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.application.dto.CompanyInfoSaveDTO;
import com.like.system.company.application.dto.CompanyInfoSaveDTOMapstruct;
import com.like.system.company.application.port.in.CompanySaveUseCase;
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
	public void save(CompanyInfoSaveDTO dto) {
		//CompanyInfo entity = CompanyInfoSaveDTOMapper.toEntity(dto);
		CompanyInfo entity = CompanyInfoSaveDTOMapstruct.INSTANCE.toEntity(dto);
		
		this.dbPort.save(entity);
	}

}
