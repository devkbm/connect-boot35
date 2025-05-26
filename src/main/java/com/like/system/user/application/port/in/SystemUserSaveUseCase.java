package com.like.system.user.application.port.in;

import java.util.List;

import com.like.system.user.application.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.application.dto.SystemUserSaveDTO;

public interface SystemUserSaveUseCase {
	void save(SystemUserSaveDTO dto);
	
	void save(List<SystemUserSaveByExcelDTO> dto);
}
