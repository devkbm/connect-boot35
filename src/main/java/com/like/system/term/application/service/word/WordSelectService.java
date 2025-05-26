package com.like.system.term.application.service.word;

import org.springframework.stereotype.Service;

import com.like.system.term.application.dto.word.WordSaveDTO;
import com.like.system.term.application.dto.word.WordSaveDTOMapper;
import com.like.system.term.application.port.in.word.WordSelectUseCase;
import com.like.system.term.application.port.out.WordCommandDbPort;

@Service
public class WordSelectService implements WordSelectUseCase {

	WordCommandDbPort dbPort;
	
	WordSelectService(WordCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public WordSaveDTO select(String id) {
		return WordSaveDTOMapper.toDTO(this.dbPort.select(id));
	}

}
