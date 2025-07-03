package com.like.hrm.attendance.application.port.in.application.select;

import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveDTO;

public interface AttendanceApplicationSelectUseCase {

	AttendanceApplicationSaveDTO select(Long id);
}
