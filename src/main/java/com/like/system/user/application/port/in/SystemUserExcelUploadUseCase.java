package com.like.system.user.application.port.in;

import java.util.List;

import com.like.system.user.application.dto.SystemUserSaveByExcelDTO2;

public interface SystemUserExcelUploadUseCase {

	void save(List<SystemUserSaveByExcelDTO2> dto);
}
