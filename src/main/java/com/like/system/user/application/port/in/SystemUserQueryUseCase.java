package com.like.system.user.application.port.in;

import java.util.List;

import com.like.system.user.application.dto.SystemUserQueryDTO;
import com.like.system.user.application.dto.SystemUserSelectDTO;

public interface SystemUserQueryUseCase {
	List<SystemUserSelectDTO> selectList(SystemUserQueryDTO dto);
}
