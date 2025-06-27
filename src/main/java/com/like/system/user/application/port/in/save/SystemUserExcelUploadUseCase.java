package com.like.system.user.application.port.in.save;

import java.util.List;

public interface SystemUserExcelUploadUseCase {

	void save(List<SystemUserSaveByExcelDTO2> dto);
}
