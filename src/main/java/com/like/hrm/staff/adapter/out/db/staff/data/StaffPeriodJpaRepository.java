package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.period.StaffPeriod;
import com.like.hrm.staff.domain.staff.period.StaffPeriodId;

public interface StaffPeriodJpaRepository extends JpaRepository<StaffPeriod, StaffPeriodId>, QuerydslPredicateExecutor<StaffPeriod> {

}
