package com.like.system.term.application.port.in.domain;

import java.util.List;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;

public interface DataDomainQueryUseCase {
	List<DataDomainSaveDTO> selectList();
}
