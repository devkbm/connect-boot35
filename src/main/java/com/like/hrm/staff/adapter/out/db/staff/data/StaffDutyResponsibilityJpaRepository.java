package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDutyId;

public interface StaffDutyResponsibilityJpaRepository extends JpaRepository<StaffDuty, StaffDutyId>, QuerydslPredicateExecutor<StaffDuty> {

}
