package com.like.system.user.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyId;

@Repository
public interface SystemUserCompanyRepository extends JpaRepository<SystemUserCompany, SystemUserCompanyId>,
													 RevisionRepository<SystemUserCompany, SystemUserCompanyId, Long>,
												     ListQuerydslPredicateExecutor<SystemUserCompany> {
}
