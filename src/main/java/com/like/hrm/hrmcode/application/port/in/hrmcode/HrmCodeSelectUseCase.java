package com.like.hrm.hrmcode.application.port.in.hrmcode;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSelectDTO;

public interface HrmCodeSelectUseCase {
	HrmCodeSelectDTO select(String type, String code);
}
