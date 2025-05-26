package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffId;

@Repository
public interface StaffJpaRepository extends JpaRepository<Staff, StaffId>, QuerydslPredicateExecutor<Staff> {			
}
