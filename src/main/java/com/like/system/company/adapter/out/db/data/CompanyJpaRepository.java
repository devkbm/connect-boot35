package com.like.system.company.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;

public interface CompanyJpaRepository extends JpaRepository<CompanyInfo, CompanyInfoId>, 
											  RevisionRepository<CompanyInfo, CompanyInfoId, Long>, 
											  ListQuerydslPredicateExecutor<CompanyInfo> {
				
}