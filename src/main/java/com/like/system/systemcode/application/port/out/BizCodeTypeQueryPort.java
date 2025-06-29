package com.like.system.systemcode.application.port.out;

import java.util.List;

import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryResultDTO;

public interface BizCodeTypeQueryPort {
	List<BizCodeTypeQueryResultDTO> select(String companyCode);
}
