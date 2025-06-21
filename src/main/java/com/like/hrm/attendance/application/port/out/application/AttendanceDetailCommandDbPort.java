package com.like.hrm.attendance.application.port.out.application;

import java.util.List;
import java.util.Optional;

import com.like.hrm.attendance.domain.application.AttendanceDetail;

public interface AttendanceDetailCommandDbPort {

	Optional<AttendanceDetail> select(Long id);
	
	void save(AttendanceDetail entity);
	
	void delete(Long id);
	
	List<AttendanceDetail> selectByAppId(Long appId);
	
	void save(List<AttendanceDetail> entity);
}
