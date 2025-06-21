package com.like.hrm.attendance.adapter.out.db.application.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.hrm.attendance.domain.application.AttendanceDetail;

public interface AttendanceDetailJpaRepository extends JpaRepository<AttendanceDetail, Long>, ListQuerydslPredicateExecutor<AttendanceDetail> {

}
