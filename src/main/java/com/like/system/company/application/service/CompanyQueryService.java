package com.like.system.company.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.adapter.out.db.data.CompanyJpaRepository;
import com.like.system.company.application.dto.CompanyInfoSaveDTO;
import com.like.system.company.application.dto.CompanyInfoSaveDTOMapstruct;
import com.like.system.company.application.port.in.CompanyQueryUseCase;

@Transactional(readOnly = true)
@Service
public class CompanyQueryService implements CompanyQueryUseCase {

	CompanyJpaRepository dbPort;
	
	CompanyQueryService(CompanyJpaRepository dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<CompanyInfoSaveDTO> query() {
		
		return this.dbPort.findAll()
						  .stream()
						  .map(e -> CompanyInfoSaveDTOMapstruct.INSTANCE.toDTO(e))
						  .toList();
	}

}
