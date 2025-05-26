package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.contact.ContactInfo;
import com.like.hrm.staff.domain.staff.contact.ContactInfoId;

public interface StaffContactInfoJpaRepository extends JpaRepository<ContactInfo, ContactInfoId>, QuerydslPredicateExecutor<ContactInfo> {

}
