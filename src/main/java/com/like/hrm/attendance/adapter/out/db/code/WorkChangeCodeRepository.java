package com.like.hrm.attendance.adapter.out.db.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.attendance.domain.code.WorkChangeCode;

public interface WorkChangeCodeRepository extends JpaRepository<WorkChangeCode, String>, QuerydslPredicateExecutor<WorkChangeCode> {

}
