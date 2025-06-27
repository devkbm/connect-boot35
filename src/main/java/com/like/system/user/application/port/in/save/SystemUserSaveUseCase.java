package com.like.system.user.application.port.in.save;

import java.util.List;

public interface SystemUserSaveUseCase {
	void save(SystemUserSaveDTO dto);
	
	void save(List<SystemUserSaveByExcelDTO> dto);
}
