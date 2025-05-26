package com.like.hrm.attendance.adapter.out.db.application.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.attendance.domain.application.AttendanceApplication;

public interface AttendanceApplicationRepository extends JpaRepository<AttendanceApplication, Long>, QuerydslPredicateExecutor<AttendanceApplication> {	
	
}
