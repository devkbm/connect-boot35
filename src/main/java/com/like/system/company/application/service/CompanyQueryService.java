package com.like.system.company.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.adapter.out.db.data.CompanyJpaRepository;
import com.like.system.company.application.port.in.query.CompanyQueryResultDTO;
import com.like.system.company.application.port.in.query.CompanyQueryResultDTOMapstruct;
import com.like.system.company.application.port.in.query.CompanyQueryUseCase;

@Transactional(readOnly = true)
@Service
public class CompanyQueryService implements CompanyQueryUseCase {

	CompanyJpaRepository dbPort;
	
	CompanyQueryService(CompanyJpaRepository dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<CompanyQueryResultDTO> query() {
		
		return this.dbPort.findAll()
						  .stream()
						  .map(e -> CompanyQueryResultDTOMapstruct.INSTANCE.toDTO(e))
						  .toList();
	}

}
