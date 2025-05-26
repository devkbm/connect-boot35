package com.like.system.term.application.port.in.term;

import com.like.system.term.application.dto.term.TermSaveDTO;

public interface TermSelectUseCase {
	TermSaveDTO select(String id);
}
