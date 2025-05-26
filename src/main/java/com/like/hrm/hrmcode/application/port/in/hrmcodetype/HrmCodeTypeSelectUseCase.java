package com.like.hrm.hrmcode.application.port.in.hrmcodetype;

import com.like.hrm.hrmcode.application.dto.hrmcodetype.HrmCodeTypeSaveDTO;

public interface HrmCodeTypeSelectUseCase {

	HrmCodeTypeSaveDTO select(String id);
}
