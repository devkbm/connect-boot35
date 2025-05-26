package com.like.system.systemcode.application.port.in;

import java.util.List;

import com.like.system.systemcode.application.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeQuerylUseCase {

	List<BizCodeTypeSaveDTO> select(String companyCode);
}
