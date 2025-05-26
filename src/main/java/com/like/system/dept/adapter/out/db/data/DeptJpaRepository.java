package com.like.system.dept.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;


import com.like.system.dept.domain.Dept;
import com.like.system.dept.domain.DeptId;

public interface DeptJpaRepository extends JpaRepository<Dept, DeptId>, ListQuerydslPredicateExecutor<Dept>,
										   RevisionRepository<Dept, DeptId, Long> {
				
}