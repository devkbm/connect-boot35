package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareer;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareerId;

public interface StaffSchoolCareerJpaRepository extends JpaRepository<StaffSchoolCareer, StaffSchoolCareerId>, QuerydslPredicateExecutor<StaffSchoolCareer> {

}
