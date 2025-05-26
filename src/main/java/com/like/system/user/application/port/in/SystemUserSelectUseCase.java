package com.like.system.user.application.port.in;

import com.like.system.user.application.dto.SystemUserSelectDTO;

public interface SystemUserSelectUseCase {
	SystemUserSelectDTO selectDTO(String userId, String companyCode);	
}
