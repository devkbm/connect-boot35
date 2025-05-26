package com.like.hrm.overtime.domain.application.port.in;

import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTO;

public interface OverTimeApplicationSaveUseCase {
	void save(OverTimeApplicationFormDTO dto);
}
