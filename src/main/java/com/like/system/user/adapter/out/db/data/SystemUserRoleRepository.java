package com.like.system.user.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.like.system.user.domain.SystemUserCompanyRole;
import com.like.system.user.domain.SystemUserCompanyRoleId;


public interface SystemUserRoleRepository extends JpaRepository<SystemUserCompanyRole, SystemUserCompanyRoleId>,
												  RevisionRepository<SystemUserCompanyRole, SystemUserCompanyRoleId, Long> {
}
