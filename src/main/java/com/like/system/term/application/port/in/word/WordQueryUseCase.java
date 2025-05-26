package com.like.system.term.application.port.in.word;

import java.util.List;

import com.like.system.term.application.dto.word.WordSaveDTO;

public interface WordQueryUseCase {
	List<WordSaveDTO> select();
}
