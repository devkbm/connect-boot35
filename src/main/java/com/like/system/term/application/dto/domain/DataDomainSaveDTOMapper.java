package com.like.system.term.application.dto.domain;

import com.like.system.term.domain.DataDomainDictionary;
import com.like.system.term.domain.Database;

public class DataDomainSaveDTOMapper {

	public static DataDomainSaveDTO toDTO(DataDomainDictionary entity) {
		return DataDomainSaveDTO.builder()
							 .domainId(entity.getId())
							 .database(entity.getDatabase().name())
							 .domainName(entity.getDomainName())
							 .dataType(entity.getDataType())
							 .comment(entity.getComment())
							 .build(); 
	}
	
	
	public static DataDomainDictionary newEntity(DataDomainSaveDTO dto) {	
		
		DataDomainDictionary entity = DataDomainDictionary.builder()
														  .database(Database.valueOf(dto.database()))
														  .domainName(dto.domainName())
														  .dataType(dto.dataType())
														  .comment(dto.comment())
														  .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
	
	public static void modifyEntity(DataDomainDictionary entity, DataDomainSaveDTO dto) {
		entity.modify(dto.dataType(), dto.comment());
	}
}
