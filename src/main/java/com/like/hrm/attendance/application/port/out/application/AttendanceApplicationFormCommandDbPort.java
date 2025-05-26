package com.like.hrm.attendance.application.port.out.application;

import java.util.Optional;

import com.like.hrm.attendance.domain.application.AttendanceApplication;

public interface AttendanceApplicationFormCommandDbPort {

	Optional<AttendanceApplication> select(Long id);
	
	void save(AttendanceApplication entity);
	
	void delete(Long id);
}
