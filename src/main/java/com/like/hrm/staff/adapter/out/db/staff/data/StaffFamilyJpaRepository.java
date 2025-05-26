package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.family.StaffFamily;
import com.like.hrm.staff.domain.staff.family.StaffFamilyId;

public interface StaffFamilyJpaRepository extends JpaRepository<StaffFamily, StaffFamilyId>, QuerydslPredicateExecutor<StaffFamily> {

}
