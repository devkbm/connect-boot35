package com.like.hrm.attendance.application.port.in.application;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationDTO;

public interface AttendanceApplicationFormSelectUseCase {

	AttendanceApplicationDTO select(Long id);
}
