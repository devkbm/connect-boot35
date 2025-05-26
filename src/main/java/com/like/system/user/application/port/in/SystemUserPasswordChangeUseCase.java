package com.like.system.user.application.port.in;

import com.like.system.user.application.dto.SystemUserPasswordChangeDTO;

public interface SystemUserPasswordChangeUseCase {
	void changePassword(SystemUserPasswordChangeDTO dto);
}
