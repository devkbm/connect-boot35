package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.license.StaffLicense;
import com.like.hrm.staff.domain.staff.license.StaffLicenseId;

public interface StaffLicenseJpaRepository extends JpaRepository<StaffLicense, StaffLicenseId>, QuerydslPredicateExecutor<StaffLicense> {

}
