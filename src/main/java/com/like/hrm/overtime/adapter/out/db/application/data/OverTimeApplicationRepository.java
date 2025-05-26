package com.like.hrm.overtime.adapter.out.db.application.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.overtime.domain.application.OverTimeApplication;

public interface OverTimeApplicationRepository extends JpaRepository<OverTimeApplication, Long>, QuerydslPredicateExecutor<OverTimeApplication> {	
	
}
