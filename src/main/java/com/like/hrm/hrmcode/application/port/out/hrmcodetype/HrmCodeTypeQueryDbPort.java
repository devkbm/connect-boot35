package com.like.hrm.hrmcode.application.port.out.hrmcodetype;

import java.util.List;

import com.like.hrm.hrmcode.application.dto.hrmcodetype.HrmCodeTypeQueryDTO;
import com.like.hrm.hrmcode.domain.HrmCodeType;

public interface HrmCodeTypeQueryDbPort {
	List<HrmCodeType> select(HrmCodeTypeQueryDTO dto);
}
