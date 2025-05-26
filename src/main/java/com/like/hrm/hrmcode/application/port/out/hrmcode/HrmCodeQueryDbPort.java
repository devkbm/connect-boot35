package com.like.hrm.hrmcode.application.port.out.hrmcode;

import java.util.List;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeQueryDTO;
import com.like.hrm.hrmcode.domain.HrmCode;

public interface HrmCodeQueryDbPort {
	List<HrmCode> select(HrmCodeQueryDTO dto);
	
	List<HrmCode> selectList(List<String> typeIds);
}
