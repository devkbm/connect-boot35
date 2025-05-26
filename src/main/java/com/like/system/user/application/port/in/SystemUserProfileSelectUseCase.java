package com.like.system.user.application.port.in;

import com.like.system.user.application.dto.SystemUserProfileSelectDTO;
import com.like.system.user.application.dto.SystemUserProfileSelectSessionDTO;

public interface SystemUserProfileSelectUseCase {

	SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto);
}
