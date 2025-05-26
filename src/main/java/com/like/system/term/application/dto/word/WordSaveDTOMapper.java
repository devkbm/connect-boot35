package com.like.system.term.application.dto.word;

import com.like.system.term.domain.WordDictionary;

public class WordSaveDTOMapper {

	public static WordSaveDTO toDTO(WordDictionary entity) {
		return WordSaveDTO.builder()
						  .logicalName(entity.getLogicalName())
						  .logicalNameEng(entity.getLogicalNameEng())
						  .physicalName(entity.getPhysicalName())
						  .comment(entity.getComment())
						  .build(); 
	}
	
	
	public static WordDictionary newEntity(WordSaveDTO dto) {
		WordDictionary entity = new WordDictionary(dto.logicalName()
												  ,dto.logicalNameEng()
												  ,dto.physicalName()
												  ,dto.comment()
												  );
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
	
	public static void modifyEntity(WordSaveDTO dto, WordDictionary entity) {
		entity.modify(dto.logicalNameEng(), dto.comment());
	}
}
