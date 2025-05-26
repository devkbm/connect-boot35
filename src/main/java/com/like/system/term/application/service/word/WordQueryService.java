package com.like.system.term.application.service.word;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.application.dto.word.WordSaveDTO;
import com.like.system.term.application.dto.word.WordSaveDTOMapper;
import com.like.system.term.application.port.in.word.WordQueryUseCase;
import com.like.system.term.application.port.out.WordQueryDbPort;

@Transactional(readOnly = true)
@Service
public class WordQueryService implements WordQueryUseCase {

	WordQueryDbPort dbPort;
	
	WordQueryService(WordQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}	
	
	@Override
	public List<WordSaveDTO> select() {
		return this.dbPort.select()
						  .stream()
						  .map(e -> WordSaveDTOMapper.toDTO(e))
						  .toList();
	}

}
