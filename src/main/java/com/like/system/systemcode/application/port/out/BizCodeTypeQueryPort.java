package com.like.system.systemcode.application.port.out;

import java.util.List;

import com.like.system.systemcode.application.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeQueryPort {
	List<BizCodeTypeSaveDTO> select(String companyCode);
}
