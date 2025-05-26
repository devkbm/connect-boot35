package com.like.hrm.attendance.adapter.out.db.code;

import java.util.List;

import com.like.hrm.attendance.application.dto.code.WorkChangeCodeDTO;
import com.like.hrm.attendance.domain.code.WorkChangeCode;

public interface WorkChangeCodeQueryRepository {
	List<WorkChangeCode> getDutyCodeList(WorkChangeCodeDTO.SearchDutyCode condition);
}
