package com.like.system.systemcode.application.port.out;

import java.util.Optional;

import com.like.system.systemcode.domain.BizCodeType;

public interface BizCodeTypeCommandDbPort {

	Optional<BizCodeType> select(String companyCode, String typeId);
	
	void Save(BizCodeType entity);
	
	void delete(String companyCode, String typeId);	
}
