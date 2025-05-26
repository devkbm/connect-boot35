package com.like.system.term.application.port.in.domain;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;

public interface DataDomainSaveUseCase {
	void save(DataDomainSaveDTO dto);
}
