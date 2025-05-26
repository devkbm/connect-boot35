package com.like.system.systemcode.application.port.out;

import java.util.Optional;

import com.like.system.systemcode.application.dto.BizCodeSaveDTO;
import com.like.system.systemcode.domain.BizCode;

public interface BizCodeCommandDbPort {

	Optional<BizCode> select(String companyCode, String typeId, String code);
	
	BizCodeSaveDTO selectDTO(String companyCode, String typeId, String code);
	
	void save(BizCode entity);
	
	void delete(String companyCode, String typeId, String code);
}
