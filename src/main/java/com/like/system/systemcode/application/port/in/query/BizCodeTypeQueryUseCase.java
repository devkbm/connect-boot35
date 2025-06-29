package com.like.system.systemcode.application.port.in.query;

import java.util.List;

public interface BizCodeTypeQueryUseCase {

	List<BizCodeTypeQueryResultDTO> select(String companyCode);
}
