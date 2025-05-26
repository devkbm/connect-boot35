package com.like.system.term.application.port.in.word;

import com.like.system.term.application.dto.word.WordSaveDTO;

public interface WordSelectUseCase {
	WordSaveDTO select(String id);
}
