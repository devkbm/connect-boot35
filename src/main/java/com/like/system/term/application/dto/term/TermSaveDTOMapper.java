package com.like.system.term.application.dto.term;

import java.util.ArrayList;
import java.util.List;

import com.like.system.term.domain.DataDomainDictionary;
import com.like.system.term.domain.TermDictionary;
import com.like.system.term.domain.WordDictionary;

public class TermSaveDTOMapper {

	public static TermSaveDTO toDTO(TermDictionary entity) {		
		return TermSaveDTO.builder()						   
					   .termId(entity.getId())
					   .system(entity.getSystem())						   
					   .term(toList(entity.getTerm()))
					   .termEng(entity.getTermEng())
					   .columnName(entity.getColumnName())
					   .dataDomainId(entity.getDataDomain().getId())
					   .dataDomainName(entity.getDataDomain().getDomainName())
					   .description(entity.getDescription())
					   .comment(entity.getComment())
					   .build();						   
	}

	private static List<String> toList(String term) {
		String[] terms = term.split("_");
		List<String> list = new ArrayList<String>(terms.length);
		
		for (int i=0; i<terms.length; i++) {				
			list.add(terms[i]);
		}
		
		return list;
	}
	
	
	
	public static TermDictionary newEntity(TermSaveDTO dto, WordDictionary word, DataDomainDictionary dataDomain) {												
		return TermDictionary.of(dto.system(), word, dto.termEng(), dataDomain, dto.description(), dto.comment());
	}
	
	public static TermDictionary newEntity(TermSaveDTO dto, List<WordDictionary> word, DataDomainDictionary dataDomain) {
		return TermDictionary.of(dto.system(), word, dto.termEng(), dataDomain, dto.description(), dto.comment());
	}
		
	public static void modifyEntity(TermSaveDTO dto, TermDictionary entity, DataDomainDictionary dataDomain) {		
		entity.modifyEntity(dto.termEng()					           
				           ,dataDomain
				           ,dto.description()
				           ,dto.comment());				
	}
}

