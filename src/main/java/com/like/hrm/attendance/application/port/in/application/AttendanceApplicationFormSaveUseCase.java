package com.like.hrm.attendance.application.port.in.application;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationFormDTO;

public interface AttendanceApplicationFormSaveUseCase {

	void save(AttendanceApplicationFormDTO dto);
}
