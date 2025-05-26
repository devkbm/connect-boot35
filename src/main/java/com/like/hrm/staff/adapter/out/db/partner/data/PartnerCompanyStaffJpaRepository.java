package com.like.hrm.staff.adapter.out.db.partner.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;
import com.like.hrm.staff.domain.staff.StaffId;

public interface PartnerCompanyStaffJpaRepository extends JpaRepository<PartnerCompanyStaff, StaffId>, QuerydslPredicateExecutor<PartnerCompanyStaff> {

}
